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
            withEnv(['APPDATA=klient/node/node_modules/npm/bin', 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
            }
        }

        stage("sonar analysis") {
            // in a multibranch pipeline, when using "GitHub Branch Source" plugin with "Discover pull requests",
            // the PR number is available in the CHANGE_ID environment variable.
            // because the same Jenkinsfile is used for both PR builds and branch builds,
            // we have to check for the existence of CHANGE_ID
            if (env.CHANGE_ID) {
                def scannerHome = tool 'sonarqube-scanner';

                // withSonarQubeEnv injects SONAR_HOST_URL and SONAR_AUTH_TOKEN (amongst others),
                // so we don't have to set them as cli args to sonar-scanner
                withSonarQubeEnv('Presys Sonar') {
                    withCredentials([string(credentialsId: 'navikt-jenkins-sonarqube', variable: 'GITHUB_OAUTH_TOKEN')]) {
                        withEnv(['SONAR_SCANNER_OPTS=-Dhttps.proxyHost=webproxy-utvikler.nav.no -Dhttps.proxyPort=8088 -Dhttp.nonProxyHosts=adeo.no']) {
                            sh "${scannerHome}/bin/sonar-scanner \
                                -Dsonar.projectKey=no.nav.pensjon.presys:persys \
                                -Dsonar.projectName=Presys \
                                -Dsonar.projectVersion=${pom.version} \
                                -Dsonar.sources=src \
                                -Dsonar.java.binaries=target \
                                -Dsonar.modules=appconfig,klient,metrics,server \
                                -Dsonar.links.scm=https://github.com/${project}/${application}.git \
                                -Dsonar.links.scm_dev=https://github.com/${project}/${application}.git \
                                -Dsonar.analysis.mode=preview \
                                -Dsonar.github.pullRequest=${env.CHANGE_ID} \
                                -Dsonar.github.repository=${project}/${application} \
                                -Dsonar.github.oauth=${env.GITHUB_OAUTH_TOKEN}"
                        }
                    }
                }
            }
        }

        stage("release snapshot") {
            sh "${mvn} versions:set -B -DnewVersion=${releaseVersion} -DgenerateBackupPoms=false"

            sh "${mvn} clean deploy -DskipTests -pl '!klient' -B -e"
        }

        stage("integration tests") {
            build([
                job: 'presys-deploy-pipeline',
                parameters: [
                    string(name: 'RELEASE_VERSION', value: releaseVersion),
                    string(name: 'COMMIT_HASH', value: commitHash),
                    string(name: 'DEPLOY_ENV', value: 't0')
                ]
            ])

            dir ("qa") {
                withEnv(["PATH+NODE=${nodeHome}", 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                    // install manually using local distribution, as the chromedriver package will
                    // try to download from Internet if else
                    sh "${npm} install chromedriver --chromedriver_filepath=/usr/local/chromedriver/chromedriver_linux64.zip"
                    sh "${npm} install"

                    sh "./node_modules/.bin/nightwatch --env jenkins"
                }
            }
        }

        slackSend([
            color: 'good',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${application}@${env.BRANCH_NAME} by ${committer} passed"
        ])

        currentBuild.result = 'SUCCESS'
    } catch (e) {
        slackSend([
            color: 'danger',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${application}@${env.BRANCH_NAME} by ${committer} failed"
        ])

        currentBuild.result = 'FAILED'
        throw e
    }
}
