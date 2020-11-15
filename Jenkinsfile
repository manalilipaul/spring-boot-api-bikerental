pipeline {
    agent any
    environment {
        registry = "manalilipaul/bikerental"
        registryCredential = 'dockerhub'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Init') {
            steps {
                echo 'Compile project'
                sh "chmod +x gradlew"
            }
        }
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Build Docker image') {
            steps {
                sh './gradlew docker --stacktrace'
            }
        }
        stage('Push Docker image') {
            steps {
                docker.withRegistry( '', registryCredential ) {
                    sh './gradlew dockerPush --stacktrace'
                }
            }

        }
    }
}