node {
    def project = "navikt"
    def application = "presys"

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"
    def nodeHome = tool "nodejs-6.6.0"
    def node = "${nodeHome}/node"
    def npm = "${nodeHome}/npm"

    def commitHash, commitHashShort, commitUrl, committer, releaseVersion

    try {
        cleanWs()

        stage("checkout") {
            checkout scm
        }

        stage("initialize") {
            pom = readMavenPom file: 'pom.xml'

            if (!pom.version.contains("-SNAPSHOT")) {
                error("Expected a SNAPSHOT version")
            }

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            commitHashShort = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
            commitUrl = "https://github.com/${project}/${application}/commit/${commitHash}"

            // rewrite XX-SNAPSHOT to XX.YY-SNAPSHOT, where YY is the commit sha
            releaseVersion = pom.version.tokenize("-")[0] + "." + commitHashShort + "-SNAPSHOT"

            /* gets the person who committed last as "Surname, First name" */
            committer = sh(script: 'git log -1 --pretty=format:"%an"', returnStdout: true).trim()
        }

        stage("build") {
            dir ("klient") {
                sh "${npm} install"
            }

            sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"

            dir ("server") {
                sh "/usr/local/bin/nais validate"
                sh "docker build -t docker.adeo.no:5000/${application}:${commitHashShort} ."
            }
        }

        // in a multibranch pipeline, when using "GitHub Branch Source" plugin with "Discover pull requests",
        // the PR number is available in the CHANGE_ID environment variable.
        // because the same Jenkinsfile is used for both PR builds and branch builds,
        // we have to check for the existence of CHANGE_ID
        if (env.CHANGE_ID) {
            stage("sonar analysis") {
                def scannerHome = tool 'sonarqube-scanner';

                // withSonarQubeEnv injects SONAR_HOST_URL and SONAR_AUTH_TOKEN (amongst others),
                // so we don't have to set them as cli args to sonar-scanner
                withSonarQubeEnv('Presys Sonar') {
                    withCredentials([string(credentialsId: 'navikt-jenkins-oauthtoken', variable: 'GITHUB_OAUTH_TOKEN')]) {
                        withEnv(['SONAR_SCANNER_OPTS=-Dhttps.proxyHost=webproxy-utvikler.nav.no -Dhttps.proxyPort=8088 -Dhttp.nonProxyHosts=adeo.no']) {
                            sh """
                                ${scannerHome}/bin/sonar-scanner \
                                    -Dsonar.projectVersion=${pom.version} \
                                    -Dsonar.analysis.mode=preview \
                                    -Dsonar.github.pullRequest=${env.CHANGE_ID} \
                                    -Dsonar.github.oauth=${env.GITHUB_OAUTH_TOKEN}
                            """
                        }
                    }
                }
            }
        }

        stage("integration tests") {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'presysDB_U', usernameVariable: 'PRESYSDB_USERNAME', passwordVariable: 'PRESYSDB_PASSWORD']]) {
                sh """
                    docker run --name ${application}-${commitHashShort} --rm -dP \
                        -e PRESYSDB_URL='jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=d26dbfl023.test.local)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PRESYSCDU1)(INSTANCE_NAME=ccuf02)(UR=A)(SERVER=DEDICATED)))' \
                        -e PRESYSDB_USERNAME \
                        -e PRESYSDB_PASSWORD \
                        -e JWT_PASSWORD=somesecret \
                        -e LDAP_URL=ldaps://ldapgw.test.local \
                        -e LDAP_BASEDN=dc=test,dc=local \
                        -e LDAP_DOMAIN=TEST.LOCAL \
                        docker.adeo.no:5000/${application}:${commitHashShort}
                """
            }

            dir ("qa") {
                withEnv(["PATH+NODE=${nodeHome}", 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                    sh "${npm} install"
                }

                dockerPort = sh(script: "docker port ${application}-${commitHashShort} 8080/tcp | sed s/.*://", returnStdout: true).trim()

                // wait for app to become ready
                timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${dockerPort}/api/internal/isReady; do sleep 1; done"
                }

                sh "PORT=${dockerPort} ./node_modules/.bin/nightwatch --env jenkins"
            }

            sh "docker stop ${application}-${commitHashShort} || true"
        }

        stage("release snapshot") {
            sh "docker push docker.adeo.no:5000/${application}:${commitHashShort}"
            sh "${mvn} clean deploy -DskipTests -B -e"

            dir ("server") {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'nexusUser', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD']]) {
                    sh "/usr/local/bin/nais upload --app ${application} -v ${commitHashShort}"
                }
            }
        }

        stage("deploy") {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'fasitUser', usernameVariable: 'NAIS_USERNAME', passwordVariable: 'NAIS_PASSWORD']]) {
                sh "/usr/local/bin/nais deploy -c nais-dev --app ${application} -v ${commitHashShort} -e cd-u1"
            }
        }

        slackSend([
            color: 'good',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${application}@${env.BRANCH_NAME} by ${committer} passed"
        ])

        currentBuild.result = 'SUCCESS'
    } catch (e) {
        sh "docker stop ${application}-${commitHashShort} || true"

        slackSend([
            color: 'danger',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${application}@${env.BRANCH_NAME} by ${committer} failed"
        ])

        currentBuild.result = 'FAILED'
        throw e
    }
}
