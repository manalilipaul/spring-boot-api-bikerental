pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
        sudo chmod +x ./gradlew
    }
    stages {
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