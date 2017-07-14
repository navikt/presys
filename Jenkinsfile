node {
    def application = "presys"

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"

    try {
        stage("checkout") {
            checkout scm
        }

        // Notifies the Stash Instance of an INPROGRESS build
        step([$class: 'StashNotifier'])

        stage("build") {
            withEnv(['APPDATA=klient/node/node_modules/npm/bin', 'HTTP_PROXY=http://webproxy-utvikler.nav.no:8088', 'NO_PROXY=adeo.no']) {
                sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
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