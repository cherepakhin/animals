pipeline {
    agent {
        docker {
            image 'maven:3.9.3-eclipse-temurin-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}