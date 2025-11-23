pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'yessinejmal/tp-foyer-app'
        DOCKER_TAG = ""
    }
    
    stages {
        stage('Checkout Git') {
            steps {
                git(
                    url: 'https://github.com/yessinecss9-svg/yessinejmal-4sae4.git',
                    credentialsId: 'github-credentials',
                    branch: 'master'
                )
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
                    docker.build(":")
                }
            }
        }
        
        // NOUVEAU STAGE : Push Docker Image
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub-credentials') {
                        docker.image(":").push()
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
