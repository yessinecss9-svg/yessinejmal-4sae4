pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'votredockerhub/nom-du-projet:latest'
        DOCKER_CREDENTIALS = 'docker-hub-credentials'
    }
    
    stages {
        // Vos stages existants
        stage('Git Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/votrecommande/votreprojet.git',
                credentialsId: 'github-credentials'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'  // Adaptez selon votre projet
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'  // Adaptez selon votre projet
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        // NOUVEAUX STAGES DOCKER
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS) {
                        docker.image("${DOCKER_IMAGE}").push()
                    }
                }
            }
        }
    }
    
    post {
        always {
            emailext (
                subject: "Build ${currentBuild.result}: Job ${env.JOB_NAME}",
                body: "Détails: ${env.BUILD_URL}",
                to: "votre@email.com"
            )
        }
    }
}
