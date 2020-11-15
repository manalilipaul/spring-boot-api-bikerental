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
            environment {
                DOCKER_HUB_LOGIN = credentials('dockerhub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush --stacktrace'
            }
        }
        stage('Deploy to AWS') {
            environment {
                DOCKER_HUB_LOGIN = credentials('dockerhub')
            }
            steps {
                withAWS(credentials: 'aws-credentials', region: env.AWS_REGION) {
                    sh './gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=$SUBNET_ID -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR -Pregion=$AWS_REGION'
                }
            }
        }
    }
}