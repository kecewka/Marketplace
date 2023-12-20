pipeline {
    agent any

    environment {
        // Define the SonarQube server credentials ID
        SONAR_TOKEN = credentials('sonarqube')
        TOMCAT_CREDENTIALS = credentials('tomcat')
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git branch: 'main', url: 'https://github.com/kecewka/Marketplace.git'
            }
        }

        stage('Build') {
            steps {
                // Build your project using Maven or other build tool
                sh 'mvn clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                // Run unit tests
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis using SonarScanner
                withSonarQubeEnv('SonarQube_Server') {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                // Deploy to Tomcat using Deploy to Container plugin
                withCredentials([usernamePassword(credentialsId: TOMCAT_CREDENTIALS, passwordVariable: 'TOMCAT_PASSWORD', usernameVariable: 'TOMCAT_USERNAME')]) {
                    sh 'mvn deploy:deploy-file -Durl=http://localhost:8101/manager/text -DrepositoryId=tomcat -Dfile=target/your-app.war -DgroupId=your.groupId -DartifactId=your-artifactId -Dversion=1.0 -Dpackaging=war -DgeneratePom=true -Dtomcat.username=$TOMCAT_USERNAME -Dtomcat.password=$TOMCAT_PASSWORD'
                }
            }
        }
    }

    post {
        success {
            // Perform actions when the pipeline succeeds
            echo 'Deployment successful!'
        }
        failure {
            // Perform actions when the pipeline fails
            echo 'Deployment failed!'
        }
    }
}
