
start the jenkins
java -jar jenkins.war --httpPort=8080

The following command was used to export the job from jenkins.

cd /opt/homebrew/Cellar/jenkins-lts/2.361.1/libexec
java -jar cli-2.361.1.jar -s http://localhost:8080 -auth aneonoir:DindaMin@123 get-job judge-dredd > judge-dredd-jenkins.xml
