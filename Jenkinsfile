#!/usr/bin/env groovy
@Library('peon-pipeline') _

node {
    def commitHash, frontendVersion, backendVersion

    try {
        cleanWs()

        stage("checkout") {
            withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'GITHUB_OAUTH_TOKEN')]) {
                sh "git init"
                sh "git pull https://${GITHUB_OAUTH_TOKEN}:x-oauth-basic@github.com/navikt/presys.git"
            }

            sh "make bump-version"

            backendVersion = sh(script: 'cat ./server/VERSION', returnStdout: true).trim()
            frontendVersion = sh(script: 'cat ./klient/VERSION', returnStdout: true).trim()

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            github.commitStatus("navikt-ci-oauthtoken", "navikt/presys", 'continuous-integration/jenkins', commitHash, 'pending', "Build #${env.BUILD_NUMBER} has started")
        }

        stage("build") {
            sh "make"
        }

        stage("integration tests") {
            sh "docker network create presys-cluster"

            withCredentials([usernamePassword(credentialsId: 'presysDB_U', usernameVariable: 'SPRING_DATASOURCE_USERNAME', passwordVariable: 'SPRING_DATASOURCE_PASSWORD'),
                             usernamePassword(credentialsId: 'srvpresys', usernameVariable: 'SERVICEUSER_USERNAME', passwordVariable: 'SERVICEUSER_PASSWORD'),
                             certificate(aliasVariable: '', credentialsId: 'nav_truststore', keystoreVariable: 'NAV_TRUSTSTORE_PATH', passwordVariable: 'NAV_TRUSTSTORE_PASSWORD')]) {
                sh """
                    docker run --name presys-${backendVersion} --rm -dP \
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
                        --hostname presys \
                        --network presys-cluster \
                        repo.adeo.no:5443/presys:${backendVersion}
                """
            }

            sh """
                docker run --name presys-frontend-${frontendVersion} --rm -dP \
                    --hostname presys-frontend \
                    --network presys-cluster \
                    repo.adeo.no:5443/presys-frontend:${frontendVersion}
            """

            dir ("qa") {
                sh "npm install"

                backendPort = sh(script: "docker port presys-${backendVersion} 8080/tcp | sed s/.*://", returnStdout: true).trim()
                frontendPort = sh(script: "docker port presys-frontend-${frontendVersion} 80/tcp | sed s/.*://", returnStdout: true).trim()

                // wait for app to become ready
                timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${backendPort}/isReady; do sleep 1; done"
                }
                timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${frontendPort}/isReady; do sleep 1; done"
                }

                sh "PORT=${frontendPort} ./node_modules/.bin/nightwatch --env jenkins"
            }

            sh "docker stop presys-${backendVersion}"
            sh "docker stop presys-frontend-${frontendVersion}"
            sh "docker network rm presys-cluster"
        }

        stage("release") {
            withCredentials([usernamePassword(credentialsId: 'nexusUploader', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                sh "docker login -u ${env.NEXUS_USERNAME} -p ${env.NEXUS_PASSWORD} repo.adeo.no:5443"
            }

            sh "make release"

            withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'GITHUB_OAUTH_TOKEN')]) {
                sh("git push --tags https://${GITHUB_OAUTH_TOKEN}:x-oauth-basic@github.com/navikt/presys.git HEAD:master")
            }

            withCredentials([usernamePassword(credentialsId: 'nexusUploader', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                sh "make manifest"
            }

            withCredentials([usernamePassword(credentialsId: 'jiraServiceUser', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                sh """
                    /usr/bin/jilease \
                        -jiraUrl https://jira.adeo.no \
                        -project PRE \
                        -application presys \
                        -version ${version} \
                        -username ${env.USERNAME} \
                        -password ${env.PASSWORD}
                """
            }
        }

        stage("deploy") {
            build([
                job: 'nais-deploy-pipeline',
                propagate: false,
                parameters: [
                    string(name: 'APP', value: "presys"),
                    string(name: 'REPO', value: "navikt/presys"),
                    string(name: 'VERSION', value: version),
                    string(name: 'COMMIT_HASH', value: commitHash),
                    string(name: 'DEPLOY_ENV', value: 'q0')
                ]
            ])
            build([
                job: 'nais-deploy-pipeline',
                propagate: false,
                parameters: [
                    string(name: 'APP', value: "presys-frontend"),
                    string(name: 'REPO', value: "navikt/presys"),
                    string(name: 'VERSION', value: version),
                    string(name: 'COMMIT_HASH', value: commitHash),
                    string(name: 'DEPLOY_ENV', value: 'q0')
                ]
            ])
        }

        github.commitStatus("navikt-ci-oauthtoken", "navikt/presys", 'continuous-integration/jenkins', commitHash, 'success', "Build #${env.BUILD_NUMBER} has finished")
    } catch (e) {
        sh "docker stop presys-${version} || true"
        sh "docker stop presys-frontend-${version} || true"
        sh "docker network rm presys-cluster || true"

        github.commitStatus("navikt-ci-oauthtoken", "navikt/presys", 'continuous-integration/jenkins', commitHash, 'failure', "Build #${env.BUILD_NUMBER} has failed")

        throw e
    }
}
