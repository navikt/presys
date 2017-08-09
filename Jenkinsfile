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

        stage("integration tests") {
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