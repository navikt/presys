@Library('peon-pipeline') _

def commitHash, frontendVersion, backendVersion, appToken

pipeline {
    agent any
        
    stages {
        stage("checkout") {
            steps {
                script {                   
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
            }
        }
        stage("build backend") {
            steps {
                script {
                    dir ("server") {
                        latestStage = env.STAGE_NAME
                        sh '''docker run --rm -t \
                        -w /usr/src \
                        -v ${PWD}:/usr/src \
                        -v ${HOME}/.m2:/var/maven/.m2 \
                        -e MAVEN_CONFIG=/var/maven/.m2 \
                        maven:3.5-jdk-11 mvn -Duser.home=/var/maven clean package -DskipTests=true -B -V'''
                        sh '''docker run --rm -t \
                        -w /usr/src \
                        -v ${PWD}:/usr/src \
                        -v /var/run/docker.sock:/var/run/docker.sock \
                        -v ${HOME}/.m2:/var/maven/.m2 \
                        -e MAVEN_CONFIG=/var/maven/.m2 \
                        maven:3.5-jdk-11 mvn -Duser.home=/var/maven verify -B -e'''
                        sh '''docker build --pull -t repo.adeo.no:5443/presys -t repo.adeo.no:5443/presys:$(cat ./VERSION) .'''                        
                    }
                }
            }
        }
        stage("build frontend") {
            steps {
                script {
                    dir("klient") {
                        latestStage = env.STAGE_NAME
                        sh "make"
                    }
                }
            }
        } 
        stage("release") {
            steps {
                script {
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
            }
        }
        stage("deploy backend") {
            steps {
                script {
                    latestStage = env.STAGE_NAME
                    env.APP_NAME = "presys"
                    env.COMMIT_HASH_LONG = commitHash
                    env.COMMIT_HASH_SHORT = backendVersion
                    
                    deployments = [
                        ["dev-fss", "default"],
                        ["prod-fss", "default"]
                   ]
                    
                    for (deployment in deployments) {
                        latestDeploy = [deployment]
                        (context, namespace) = deployment
                        deploy.naiserator(context, namespace, "server/nais.yaml")
                    }
                    
                    slack.notification("good", ":monkey_face:", latestStage, deployments)                    
                }
            }
        }
        stage("deploy frontend") {
            steps {
                script {
                    latestStage = env.STAGE_NAME
                    env.APP_NAME = "presys-frontend"
                    env.COMMIT_HASH_LONG = commitHash
                    env.COMMIT_HASH_SHORT = frontendVersion
                    
                    for (deployment in deployments) {
                        latestDeploy = [deployment]
                        (context, namespace) = deployment
                        deploy.naiserator(context, namespace, "klient/nais.yaml")
                    }
                    
                    slack.notification("good", ":monkey_face:", latestStage, deployments)                    
                }
            }
        }
    }
    post {
        success {
            script {
                github.commitStatus("success", "navikt/presys", appToken, commitHash)
            }
        }
        failure {
            script {
                github.commitStatus("failure", "navikt/presys", appToken, commitHash)
                slack.notification("danger", ":gorilla:", latestStage, latestDeploy)
            }
        }
    }
}
