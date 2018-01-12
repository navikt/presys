node {
    def project = "navikt"
    def repoName = "presys"
    def application = "presys"

    /* metadata */
    def commitHash, commitHashShort, commitUrl, committer, pom, currentVersion, releaseVersion

    def mvnHome = tool "maven-3.3.9"
    def nodeHome = tool "nodejs-6.9.4"

    try {
        // delete whole workspace before starting the build,
        // so that the 'git clone' command below doesn't fail due to
        // directory not being empty
        cleanWs()

        stage("checkout") {
            // we are cloning the repository manually, because the standard 'git' and 'checkout' steps
            // infer with the Git polling that Jenkins already does (when polling for changes to the
            // repo containing the Jenkinsfile).
            withEnv(['HTTPS_PROXY=http://webproxy-utvikler.nav.no:8088']) {
                sh(script: "git clone https://github.com/${project}/${repoName}.git .")
            }

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            commitHashShort = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
            commitUrl = "https://github.com/${project}/${repoName}/commit/${commitHash}"

            /* gets the person who committed last as "Surname, First name" */
            committer = sh(script: 'git log -1 --pretty=format:"%an"', returnStdout: true).trim()

            notifyGithub(project, repoName, 'continuous-integration/jenkins', commitHash, 'pending', "Build #${env.BUILD_NUMBER} has started")
        }

        stage("initialize") {
            pom = readMavenPom file: 'pom.xml'
            currentVersion = pom.version
            releaseVersion = pom.version.tokenize("-")[0]
            nextVersion = (releaseVersion.toInteger() + 1) + "-SNAPSHOT"
        }

        stage("build") {
            dir ("klient") {
                withEnv(["PATH+NODE=${nodeHome}/bin", 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                    sh "npm install"
                }
            }

            withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                sh "mvn versions:set -B -DnewVersion=${releaseVersion} -DgenerateBackupPoms=false"
            }

            sh "git add '*pom.xml'"
            sh "git commit -m 'Commit before creating tag ${application}-${releaseVersion}'"
            sh "git tag -am 'auto-tag by build pipeline' ${application}-${releaseVersion}"

            withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test -Djava.io.tmpdir=/tmp/${application} -B -e"
            }

            dir ("server") {
                sh "/usr/local/bin/nais validate"
                sh "docker build --pull -t docker.adeo.no:5000/${application}:${releaseVersion} ."
            }
        }

        stage("integration tests") {
            withCredentials([usernamePassword(credentialsId: 'presysDB_U', usernameVariable: 'SPRING_DATASOURCE_USERNAME', passwordVariable: 'SPRING_DATASOURCE_PASSWORD'),
                             usernamePassword(credentialsId: 'srvpresys', usernameVariable: 'SERVICEUSER_USERNAME', passwordVariable: 'SERVICEUSER_PASSWORD'),
                             certificate(aliasVariable: '', credentialsId: 'nav_truststore', keystoreVariable: 'NAV_TRUSTSTORE_PATH', passwordVariable: 'NAV_TRUSTSTORE_PASSWORD')]) {
                sh """
                    docker run --name ${application}-${commitHashShort} --rm -dP \
                        -e NAV_TRUSTSTORE_PATH=/app/cacerts \
                        -e NAV_TRUSTSTORE_PASSWORD \
                        -e SPRING_DATASOURCE_URL='jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=d26dbfl023.test.local)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PRESYSCDU1)(INSTANCE_NAME=ccuf02)(UR=A)(SERVER=DEDICATED)))' \
                        -e SPRING_DATASOURCE_USERNAME \
                        -e SPRING_DATASOURCE_PASSWORD \
                        -e ABAC_URL=https://wasapp-t0.adeo.no/asm-pdp/authorize \
                        -e SERVICEUSER_USERNAME \
                        -e SERVICEUSER_PASSWORD \
                        -e JWT_PASSWORD=somesecret \
                        -e LDAP_URL=ldaps://ldapgw.preprod.local \
                        -e LDAP_BASEDN=dc=preprod,dc=local \
                        -v ${NAV_TRUSTSTORE_PATH}:/app/cacerts \
                        docker.adeo.no:5000/${application}:${commitHashShort}
                """
            }

            dir ("qa") {
                withEnv(["PATH+NODE=${nodeHome}/bin", 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                    sh "npm install"
                }

                dockerPort = sh(script: "docker port ${application}-${releaseVersion} 8080/tcp | sed s/.*://", returnStdout: true).trim()

                // wait for app to become ready
                timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${dockerPort}/isReady; do sleep 1; done"
                }

                sh "PORT=${dockerPort} ./node_modules/.bin/nightwatch --env jenkins"
            }

            sh "docker stop ${application}-${releaseVersion} || true"
        }

        stage("sonar analysis") {
            def scannerHome = tool 'sonarqube-scanner';

            // withSonarQubeEnv injects SONAR_HOST_URL and SONAR_AUTH_TOKEN (amongst others),
            // so we don't have to set them as cli args to sonar-scanner
            withSonarQubeEnv('Presys Sonar') {
                sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectVersion=${pom.version}"
            }
        }

        stage("release") {
            sh "docker push docker.adeo.no:5000/${application}:${releaseVersion}"

            dir ("server") {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'nexusUser', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD']]) {
                    sh "/usr/local/bin/nais upload --app ${application} -v ${releaseVersion}"
                }
            }

            withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                sh "mvn versions:set -B -DnewVersion=${nextVersion} -DgenerateBackupPoms=false"
            }

            sh "git add '*pom.xml'"
            sh "git commit -m 'Updated version to ${nextVersion} after release'"

            withEnv(['HTTPS_PROXY=http://webproxy-utvikler.nav.no:8088']) {
                withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'GITHUB_OAUTH_TOKEN')]) {
                    sh("git push --tags https://${GITHUB_OAUTH_TOKEN}:x-oauth-basic@github.com/navikt/presys.git master")
                }
            }

            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'jiraServiceUser', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                sh "/usr/bin/jilease -jiraUrl https://jira.adeo.no -project PRE -application ${application} -version ${releaseVersion} -username ${env.USERNAME} -password ${env.PASSWORD}"
            }
        }

        stage("deploy") {
            build([
                job: 'presys-deploy-pipeline',
                propagate: false,
                parameters: [
                    string(name: 'RELEASE_VERSION', value: releaseVersion),
                    string(name: 'COMMIT_HASH', value: commitHash),
                    string(name: 'DEPLOY_ENV', value: 'p')
                ]
            ])
        }

        notifyGithub(project, repoName, 'continuous-integration/jenkins', commitHash, 'success', "Build #${env.BUILD_NUMBER} has finished")
        slackSend([
            color: 'good',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${repoName}@master by ${committer} passed"
        ])
    } catch (e) {
        sh "docker stop ${application}-${releaseVersion} || true"

        notifyGithub(project, repoName, 'continuous-integration/jenkins', commitHash, 'failure', "Build #${env.BUILD_NUMBER} has failed")
        slackSend([
            color: 'danger',
            message: "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> (<${commitUrl}|${commitHashShort}>) of ${project}/${repoName}@master by ${committer} failed"
        ])

        throw e
    }
}

def notifyGithub(owner, repo, context, sha, state, description) {
    def postBody = [
            state: "${state}",
            context: "${context}",
            description: "${description}",
            target_url: "${env.BUILD_URL}"
    ]
    def postBodyString = groovy.json.JsonOutput.toJson(postBody)

    withEnv(['HTTPS_PROXY=http://webproxy-utvikler.nav.no:8088']) {
        withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'GITHUB_OAUTH_TOKEN')]) {
            sh """
                curl -H 'Authorization: token ${GITHUB_OAUTH_TOKEN}' \
                    -H 'Content-Type: application/json' \
                    -X POST \
                    -d '${postBodyString}' \
                    'https://api.github.com/repos/${owner}/${repo}/statuses/${sha}'
            """
        }
    }
}
