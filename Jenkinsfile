@Library('deploy')
import deploy

def deployLib = new deploy()

node {
    def project = "teampesys"
    def repoName = "dsf-web"
    def application = "presys"

    /* environment mappings */
    def environmentMap = [
            "dev": "cd-u1"
    ]
    def environmentUrlMap = [
            "dev": "https://e34jbsl01778.devillo.no:8443"
    ]

    /* metadata */
    def committer, committerEmail, pom, releaseVersion, isSnapshot

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"

    try {
        stage("checkout") {
            git url: "ssh://git@stash.devillo.no:7999/${project}/${repoName}.git"
        }

        stage("initialize") {
            pom = readMavenPom file: 'pom.xml'
            releaseVersion = pom.version
            isSnapshot = pom.version.contains("-SNAPSHOT")

            /* gets the person who committed last as "Surname, First name (email@domain.tld) */
            committer = sh(script: 'git log -1 --pretty=format:"%an (%ae)"', returnStdout: true).trim()
            /* ... same as above but only email */
            committerEmail = sh(script: 'git log -1 --pretty=format:"%ae"', returnStdout: true).trim()
        }

        stage("build") {
            sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
        }

        stage("release") {
            /* deploy appconfig og ear */
            dir('appconfig') {
                sh "${mvn} clean deploy -DskipTests -B -e"
            }

            dir('ear') {
                sh "${mvn} clean deploy -DskipTests -B -e"
            }
        }

        stage("deploy") {
            /* deploy to U environment. later we would want to deploy to T also */
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'fasitUser', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                sh "${mvn} aura:deploy -Dapps=${application}:${releaseVersion} -Denv=${environmentMap['dev']} -Dusername=${USERNAME} -Dpassword=${PASSWORD}"
            }
        }

        hipchatSend (
                color: 'GREEN',
                message: "Deployet ${application}:${releaseVersion} til U: ${environmentUrlMap['dev']}\nBranch: ${env.BRANCH_NAME}\nBygg URL: ${env.BUILD_URL}\nCommitter: ${committer}",
                textFormat: true,
                v2enabled: true
        )
    } catch (e) {
        hipchatSend (
                color: 'RED',
                message: "@all ${env.JOB_NAME} #${env.BUILD_NUMBER} failed:(\nFeilmelding: "  + e.getMessage() + "\n\nBranch: ${env.BRANCH_NAME}\nBygg URL: ${env.BUILD_URL}\nCommitter: ${committer}" ,
                textFormat: true,
                notify: true,
                v2enabled: true
        )
        throw e
    }
}