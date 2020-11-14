pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
        sudo chmod +x gradlew
    }
    stages {
        stage('Build') {
            steps {
                sudo gradlew assemble
            }
        }
        stage('Test') {
            steps {
                sudo gradlew test
            }
        }

    }
}