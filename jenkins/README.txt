

start jenkins

brew services start jenkins-lts

The following command was used to export the job from jenkins.

cd /opt/homebrew/Cellar/jenkins-lts/2.361.1/libexec
java -jar cli-2.361.1.jar -s http://localhost:8080 -auth aneonoir:DindaMin@123 get-job judge-dredd > judge-dredd-jenkins.xml
