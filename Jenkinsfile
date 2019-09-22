node {
stage (‘SCM checkout’){
git “https://github.com/MarceloPV21/TCC”
}
stage (‘Build’){
dir(“ccurso-webdriver-java”) {
sh “mvn clean install”
}
dir(“comtest/target”) {
sh “java -jar com.test-1.0-SNAPSHOT.jar”
}
}
}