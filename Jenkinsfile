#!/usr/bin/env groovy
@Library('peon-pipeline') _

node {
    def commitHash, frontendVersion, backendVersion, appToken

    try {
        cleanWs()

        stage("checkout") {
            latestStage = env.STAGE_NAME
            appToken = github.generateAppToken()
            sh "git init"
            sh "git pull https://x-access-token:$appToken@github.com/navikt/presys.git"


            sh "make bump-version"

            backendVersion = sh(script: 'cat ./server/VERSION', returnStdout: true).trim()
            frontendVersion = sh(script: 'cat ./klient/VERSION', returnStdout: true).trim()

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            github.commitStatus("pending", "navikt/presys", appToken, commitHash)
        }

        stage("build") {
            agent {
                dockerfile {
                    filename "server/Dockerfile"
                }
            }
            latestStage = env.STAGE_NAME
            sh "make"
        }

        // TODO: Fix integration test!
//        stage("integration tests") {
//            sh "docker network create presys-cluster"
//
//            withCredentials([usernamePassword(credentialsId: 'presysDB_U', usernameVariable: 'SPRING_DATASOURCE_USERNAME', passwordVariable: 'SPRING_DATASOURCE_PASSWORD'),
//                             usernamePassword(credentialsId: 'srvpresys', usernameVariable: 'SERVICEUSER_USERNAME', passwordVariable: 'SERVICEUSER_PASSWORD'),
//                             certificate(aliasVariable: '', credentialsId: 'nav_truststore', keystoreVariable: 'NAV_TRUSTSTORE_PATH', passwordVariable: 'NAV_TRUSTSTORE_PASSWORD')]) {
//                sh """
//                    docker run --name presys --rm -dP \
//                        -e NAV_TRUSTSTORE_PATH=/app/cacerts \
//                        -e NAV_TRUSTSTORE_PASSWORD \
//                        -e SPRING_DATASOURCE_URL='jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=d26dbfl023.test.local)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PRESYSCDU1)(INSTANCE_NAME=ccuf02)(UR=A)(SERVER=DEDICATED)))' \
//                        -e SPRING_DATASOURCE_USERNAME \
//                        -e SPRING_DATASOURCE_PASSWORD \
//                        -e ABAC_URL=https://wasapp-t0.adeo.no/asm-pdp/authorize \
//                        -e SERVICEUSER_USERNAME \
//                        -e SERVICEUSER_PASSWORD \
//                        -e JWT_PASSWORD=somesecret \
//                        -e LDAP_URL=ldaps://ldapgw.preprod.local \
//                        -e LDAP_BASEDN=dc=preprod,dc=local \
//                        -v ${NAV_TRUSTSTORE_PATH}:/app/cacerts \
//                        --network presys-cluster \
//                        repo.adeo.no:5443/presys:${backendVersion}
//                """
//            }
//
//            sh """
//                docker run --name presys-frontend --rm -dP \
//                    --network presys-cluster \
//                    repo.adeo.no:5443/presys-frontend:${frontendVersion}
//            """
//
//            dir ("qa") {
//                sh "npm install"
//
//                backendPort = sh(script: "docker port presys 8080/tcp | sed s/.*://", returnStdout: true).trim()
//                frontendPort = sh(script: "docker port presys-frontend 80/tcp | sed s/.*://", returnStdout: true).trim()
//
//                // wait for app to become ready
//                timeout(time: 180, unit: 'SECONDS') {
//                    sh "until curl -o /dev/null -s --head --fail http://localhost:${backendPort}/isReady; do sleep 1; done"
//                }
//                timeout(time: 180, unit: 'SECONDS') {
//                    sh "until curl -o /dev/null -s --head --fail http://localhost:${frontendPort}/isReady; do sleep 1; done"
//                }
//
//                sh "PORT=${frontendPort} ./node_modules/.bin/nightwatch --env jenkins"
//            }
//
//            sh "docker stop presys || true"
//            sh "docker stop presys-frontend"
//            sh "docker network rm presys-cluster"
//        }

        stage("release") {
            latestStage = env.STAGE_NAME
            withCredentials([usernamePassword(credentialsId: 'nexusUploader', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                sh "docker login -u ${env.NEXUS_USERNAME} -p ${env.NEXUS_PASSWORD} repo.adeo.no:5443"
            }

            sh "make release"

            sh "git push --tags https://x-access-token:$appToken@github.com/navikt/presys HEAD:master"


            withCredentials([usernamePassword(credentialsId: 'nexusUploader', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                sh "make manifest"
            }
        }

        stage("deploy backend") {
            latestStage = env.STAGE_NAME
            env.APP_NAME = "presys"
            env.COMMIT_HASH_LONG=commitHash
            env.COMMIT_HASH_SHORT=backendVersion
            deployments = [
                    ["dev-fss", "default"]
            ]

            for (deployment in deployments) {
                latestDeploy = [deployment]
                (context, namespace) = deployment
                deploy.naiserator(context, namespace, "server/nais.yaml")
            }

            slack.notification("good", ":monkey_face:", latestStage, deployments)
        }

        stage("deploy frontend") {
            latestStage = env.STAGE_NAME
            env.APP_NAME = "presys-frontend"
            env.COMMIT_HASH_LONG=commitHash
            env.COMMIT_HASH_SHORT=frontendVersion

            for (deployment in deployments) {
                latestDeploy = [deployment]
                (context, namespace) = deployment
                deploy.naiserator(context, namespace, "klient/nais.yaml")
            }

            slack.notification("good", ":monkey_face:", latestStage, deployments)
        }

        github.commitStatus("success", "navikt/presys", appToken, commitHash)
    } catch (e) {
//        sh "docker stop presys || true"
//        sh "docker stop presys-frontend || true"
//        sh "docker network rm presys-cluster || true"

        github.commitStatus("failure", "navikt/presys", appToken, commitHash)
        slack.notification("danger", ":gorilla:", latestStage, latestDeploy)

        throw e
    }
}
