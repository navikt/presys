@Library('deploy')
import deploy

def deployLib = new deploy()

node {
    def application = "dsf-web"

    /* metadata */
    def committer, committerEmail, pom, releaseVersion, isSnapshot, nextVersion

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"

    try {
        stage("initialize") {
            git url: "ssh://git@stash.devillo.no:7999/teampesys/${application}.git"
            pom = readMavenPom file: 'pom.xml'
            releaseVersion = pom.version.tokenize("-")[0]
            isSnapshot = pom.version.contains("-SNAPSHOT")

            /* gets the person who committed last as "Surname, First name (email@domain.tld) */
            committer = sh(script: 'git log -1 --pretty=format:"%an (%ae)"', returnStdout: true).trim()
            /* ... same as above but only email */
            committerEmail = sh(script: 'git log -1 --pretty=format:"%ae"', returnStdout: true).trim()

            sh '''
                echo "Verifying that no snapshot dependencies is being used."
                grep module pom.xml | cut -d">" -f2 | cut -d"<" -f1 > snapshots.txt
                echo "./" >> snapshots.txt
                
                while read line;do 
                    if [ "$line" != "" ];then 
                        if [ `grep SNAPSHOT $line/pom.xml | wc -l` -gt 1 ];then 
                            echo "SNAPSHOT-dependencies found. See file $line/pom.xml.";
                            exit 0;
                        fi;
                    fi;
                done < snapshots.txt
            '''
        }

        stage("build") {
            sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
        }

        stage("release") {
            if (isSnapshot) {
                /* deploy appconfig og ear */
                /*sh "${mvn} clean deploy -DskipTests -B -e"*/
            } else {
                println("POM version is not a SNAPSHOT, it is ${pom.version}. Skipping publishing!")
            }

            println("Release versjon: " + releaseVersion)
            // nextVersion = (releaseVersion.toInteger() + 1) + "-SNAPSHOT"
        }

        stage("deploy") {
            println("Would deploy to U")
        }

        hipchatSend color: 'GREEN', message: "Deployet ${application}:${releaseVersion} til U.\n\nCommitter: ${committer}", textFormat: true, v2enabled: true
    } catch (e) {
        currentBuild.result='FAILURE'
        hipchatSend color: 'RED', message: "@all ${env.JOB_NAME} failed:(\nSe "  + e.getMessage() + " for mer informasjon.\n\nCommitter: ${committer}" , textFormat: true, notify: true, v2enabled: true

        throw e
    }
}