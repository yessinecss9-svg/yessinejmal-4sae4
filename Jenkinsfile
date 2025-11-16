pipeline {
    agent any
    
    // ⚠️ SUPPRIMEZ TOUTE CETTE SECTION :
    // tools {
    //     maven 'M3'
    //     jdk 'jdk17'
    // }
    
    stages {
        stage('Checkout Git') {
            steps {
                git(
                    url: 'https://github.com/yessinecss9-svg/yessinejmal-4sae4.git',
                    credentialsId: 'github-credentials',
                    branch: 'main'
                )
            }
        }
        
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
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
            echo '✅ Build Spring Boot successful!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
