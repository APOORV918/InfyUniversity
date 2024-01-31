pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh ' cd C:\ProgramData\Jenkins\.jenkins\workspace\InfyUniversity && mvn -B -DskipTests clean package'
            }
        }
    }
}
