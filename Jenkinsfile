pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'yessinejmal/tp-foyer-app:latest'
    }

    stages {
        stage('Checkout Git') {
            steps {
                git branch: 'master', 
                url: 'https://github.com/yessinecss9-svg/yessinejmal-4sae4.git',
                credentialsId: 'github-credentials'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        // NOUVEAU STAGE : Build Docker Image
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }

        // NOUVEAU STAGE : Push Docker Image
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                        docker.image("${DOCKER_IMAGE}").push()
                    }
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build successful! Docker image pushed to Docker Hub'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
