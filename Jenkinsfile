pipeline {
    agent any
    options {
        durabilityHint 'MAX_SURVIVABILITY'
    }
    stages {
        stage('git clone') {
            steps {
                sh 'pwd'
                sh 'rm -rf animals'
                sh 'git clone https://github.com/cherepakhin/animals.git'
                sh 'ls'
            }
        }
        stage('unit tests') {
            steps {
                sh 'ls'
                sh 'cd animals;chmod +x mvnw;ls -al;pwd'
                sh 'pwd;ls -al;cd animals;./mvnw test -Dtest=!*_IntegrationTest'
                sh 'ls'
            }
        }
        stage('deploy to nexus') {
            steps {
                sh 'ls'
                sh 'cd animals;ls;./mvnw -Dmaven.test.skip=true deploy'
                sh 'ls'
            }
        }
    }
}
