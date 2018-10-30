#!/usr/bin/env groovy
@Library('peon-pipeline') _

def createRlm(String version) {

    withCredentials([usernamePassword(credentialsId: 'jiraServiceUser', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        def app = "presys"
        def postBody = [
                fields: [
                        project          : [key: 'PROD'],
                        summary          : app + version,
                        description: "Produksjonsetting av " + app + version ,
                        issuetype: [ name: "Produksjonsendring" ],
                        customfield_21440: [id:"25705", value: "Continuous delivery (CD)"],
                        customfield_21110: [id:"25279", value: "Registrer tjeneste og komponent"],
                        customfield_20768: [[id:"CMDB-32605", value: "Presys (Pensjon)"]],
                        customfield_20717: [[id:"CMDB-419" , value: "Presys"]],
                        customfield_20761: [id:"24993" , value: "Nei"]
                ]
        ]

        def postBodyString = groovy.json.JsonOutput.toJson(postBody)
        def base64encoded = "${env.USERNAME}:${env.PASSWORD}".bytes.encodeBase64().toString()

        //System.setProperty("http.nonProxyHosts", "*.adeo.no")

        def response = httpRequest(
                url: 'https://jira.adeo.no/rest/api/2/issue/',
                customHeaders: [[name: "Authorization", value: "Basic ${base64encoded}"]],
                consoleLogResponseBody: true,
                contentType: 'APPLICATION_JSON',
                httpMode: 'POST',
                requestBody: postBodyString
        )
        def slurper = new groovy.json.JsonSlurperClassic()
        return slurper.parseText(response.content)
    }
}

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
            /*
            sh "docker network create presys-cluster"

            withCredentials([usernamePassword(credentialsId: 'presysDB_U', usernameVariable: 'SPRING_DATASOURCE_USERNAME', passwordVariable: 'SPRING_DATASOURCE_PASSWORD'),
                             usernamePassword(credentialsId: 'srvpresys', usernameVariable: 'SERVICEUSER_USERNAME', passwordVariable: 'SERVICEUSER_PASSWORD'),
                             certificate(aliasVariable: '', credentialsId: 'nav_truststore', keystoreVariable: 'NAV_TRUSTSTORE_PATH', passwordVariable: 'NAV_TRUSTSTORE_PASSWORD')]) {
                sh """
                    docker run --name presys --rm -dP \
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
                        --network presys-cluster \
                        repo.adeo.no:5443/presys:${backendVersion}
                """
            }

            sh """
                docker run --name presys-frontend --rm -dP \
                    --network presys-cluster \
                    repo.adeo.no:5443/presys-frontend:${frontendVersion}
            """

            dir ("qa") {
                sh "npm install"

                backendPort = sh(script: "docker port presys 8080/tcp | sed s/.*://", returnStdout: true).trim()
                frontendPort = sh(script: "docker port presys-frontend 80/tcp | sed s/.*://", returnStdout: true).trim()

                // wait for app to become ready
                /*timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${backendPort}/isReady; do sleep 1; done"
                }*//*
                timeout(time: 180, unit: 'SECONDS') {
                    sh "until curl -o /dev/null -s --head --fail http://localhost:${frontendPort}/isReady; do sleep 1; done"
                }

                sh "PORT=${frontendPort} ./node_modules/.bin/nightwatch --env jenkins"
            }

            sh "docker stop presys || true"
            sh "docker stop presys-frontend"
            sh "docker network rm presys-cluster"
        */
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
                        -version ${backendVersion} \
                        -username ${env.USERNAME} \
                        -password ${env.PASSWORD}
                """
            }
            createRlm(backendVersion)
        }

        stage("deploy preprod") {
            steps {
                parallel backend: {
                    build([
                        job: 'nais-deploy-pipeline',
                        propagate: true,
                        parameters: [
                            string(name: 'APP', value: "presys"),
                            string(name: 'REPO', value: "navikt/presys"),
                            string(name: 'VERSION', value: backendVersion),
                            string(name: 'COMMIT_HASH', value: commitHash),
                            string(name: 'DEPLOY_ENV', value: 'q0')
                        ]
                    ])
                },
                frontend: {
                    build([
                        job: 'nais-deploy-pipeline',
                        propagate: true,
                        parameters: [
                            string(name: 'APP', value: "presys-frontend"),
                            string(name: 'REPO', value: "navikt/presys"),
                            string(name: 'VERSION', value: frontendVersion),
                            string(name: 'COMMIT_HASH', value: commitHash),
                            string(name: 'DEPLOY_ENV', value: 'q0')
                        ]
                    ])
                }
            }
        }
        
        stage("deploy prod") {
            build([
                    job: 'nais-deploy-pipeline',
                    propagate: true,
                    parameters: [
                            string(name: 'APP', value: "presys"),
                            string(name: 'REPO', value: "navikt/presys"),
                            string(name: 'VERSION', value: backendVersion),
                            string(name: 'COMMIT_HASH', value: commitHash),
                            string(name: 'DEPLOY_ENV', value: 'p')
                    ]
            ])
            build([
                    job: 'nais-deploy-pipeline',
                    propagate: true,
                    parameters: [
                            string(name: 'APP', value: "presys-frontend"),
                            string(name: 'REPO', value: "navikt/presys"),
                            string(name: 'VERSION', value: frontendVersion),
                            string(name: 'COMMIT_HASH', value: commitHash),
                            string(name: 'DEPLOY_ENV', value: 'p')
                    ]
            ])
        }

        github.commitStatus("navikt-ci-oauthtoken", "navikt/presys", 'continuous-integration/jenkins', commitHash, 'success', "Build #${env.BUILD_NUMBER} has finished")
    } catch (e) {
        sh "docker stop presys || true"
        sh "docker stop presys-frontend || true"
        sh "docker network rm presys-cluster || true"

        github.commitStatus("navikt-ci-oauthtoken", "navikt/presys", 'continuous-integration/jenkins', commitHash, 'failure', "Build #${env.BUILD_NUMBER} has failed")

        throw e
    }
}
