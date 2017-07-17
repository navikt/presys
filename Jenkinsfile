node {
    def application = "presys"

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"

    def committer, releaseVersion

    try {
        stage("checkout") {
            checkout scm
        }

        // Notifies the Stash Instance of an INPROGRESS build
        step([$class: 'StashNotifier'])

        stage("initialize") {
            pom = readMavenPom file: 'pom.xml'

            if (!pom.version.contains("-SNAPSHOT")) {
                error("Expected a SNAPSHOT version")
            }

            commitHash = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()

            // rewrite XX-SNAPSHOT to XX.YY-SNAPSHOT, where YY is the commit sha
            releaseVersion = pom.version.tokenize("-")[0] + "." + commitHash + "-SNAPSHOT"

            /* gets the person who committed last as "Surname, First name (email@domain.tld) */
            committer = sh(script: 'git log -1 --pretty=format:"%an (%ae)"', returnStdout: true).trim()
        }

        stage("build") {
            withEnv(['APPDATA=klient/node/node_modules/npm/bin', 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
            }
        }

        stage("release snapshot") {
            sh "${mvn} versions:set -B -DnewVersion=${releaseVersion} -DgenerateBackupPoms=false"

            sh "${mvn} clean deploy -DskipTests -pl '!klient' -B -e"
        }

        stage("deploy til t0") {
            def callback = "${env.BUILD_URL}input/Deploy/"
            def deploy = deployApp(application, releaseVersion, "t0", callback, committer)

            println("Issue: https://jira.adeo.no/browse/" + deploy.key);

            timeout(time: 15, unit: 'MINUTES') {
                input id: 'deploy', message: "deployer ${deploy.key}, deploy OK?"
            }
        }

        currentBuild.result = 'SUCCESS'
        step([$class: 'StashNotifier'])
    } catch (e) {
        currentBuild.result = 'FAILED'
        step([$class: 'StashNotifier'])
        throw e
    }
}

def deployApp(app, version, environment, callback, reporter) {
    def environmentId = [
            "t0": "16556",
            "q1": "16825"
    ]

    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'jiraServiceUser', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
        def postBody = [
                fields: [
                        project          : [key: 'DEPLOY'],
                        issuetype        : [id: '10902'],
                        customfield_14811: [id: environmentId[environment], value: environmentId[environment]],
                        customfield_14812: "${app}:${version}",
                        customfield_17410: callback,
                        summary          : "Automatisk deploy på vegne av ${reporter}"
                ]
        ]

        def postBodyString = groovy.json.JsonOutput.toJson(postBody)
        def base64encoded = "${env.USERNAME}:${env.PASSWORD}".bytes.encodeBase64().toString()

        def response = httpRequest (
                url: 'https://jira.adeo.no/rest/api/2/issue/',
                customHeaders: [[name: "Authorization", value: "Basic ${base64encoded}"]],
                consoleLogResponseBody: true,
                contentType: 'APPLICATION_JSON',
                httpMode: 'POST',
                requestBody: postBodyString
        )
        def slurper = new groovy.json.JsonSlurperClassic()
        return slurper.parseText(response.content);
    }
}