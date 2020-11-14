pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'

    }
    stages {
        stage('Init') {
            steps {
                echo 'Compile project'
                sh "chmod +x gradlew"
                sh "./gradlew clean build --no-daemon"
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

    }
}