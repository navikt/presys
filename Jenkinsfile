node {
    def project = "teampesys"
    def repoName = "dsf-web"
    def application = "presys"

    /* metadata */
    def commitHash, commitUrl, committer, committerEmail, pom, currentVersion

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"
    def nodeHome = tool "nodejs-6.6.0"
    def npm = "${nodeHome}/npm"

    try {
        stage("checkout") {
            checkout scm
        }

        stage("initialize") {
            pom = readMavenPom file: 'pom.xml'
            currentVersion = pom.version

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            commitUrl = "http://stash.devillo.no/projects/${project}/repos/${repoName}/commits/${commitHash}"

            /* gets the person who committed last as "Surname, First name (email@domain.tld) */
            committer = sh(script: 'git log -1 --pretty=format:"%an (%ae)"', returnStdout: true).trim()
            /* ... same as above but only email */
            committerEmail = sh(script: 'git log -1 --pretty=format:"%ae"', returnStdout: true).trim()
        }

        stage("build") {
            withEnv(['APPDATA=klient/node/node_modules/npm/bin', 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
            }
        }

        hipchatSend(
                color: 'GREEN',
                message: "Bygget ${application}:${currentVersion} uten problem\nBranch: ${env.BRANCH_NAME}\nBygg URL: ${env.BUILD_URL}\nCommitter: ${committer}\nCommit URL: ${commitUrl}",
                textFormat: true,
                v2enabled: true
        )
    } catch (e) {
        hipchatSend (
                color: 'RED',
                message: "${env.JOB_NAME} #${env.BUILD_NUMBER} failed:(\nFeilmelding: "  + e.getMessage() + "\n\nBranch: ${env.BRANCH_NAME}\nBygg URL: ${env.BUILD_URL}\nCommitter: ${committer}\nCommit URL: ${commitUrl}" ,
                textFormat: true,
                notify: true,
                v2enabled: true
        )
        throw e
    }
}