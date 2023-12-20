pipeline {
    agent any


    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git branch: 'main', url: 'https://github.com/kecewka/Marketplace.git'
            }
        }

        stage('Build') {
            steps {
                // Build your project using Maven
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
            environment {
                // Define SonarQube server credentials from Jenkins credentials store
                SONAR_TOKEN = credentials('sonarqube')
            }
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
                // Replace TOMCAT_URL with your Tomcat server URL
                // Adjust WAR file path and other configurations as needed
                sh 'mvn deploy:deploy-file -Durl=http://localhost:8101/manager/text -DrepositoryId=tomcat -Dfile=target/your-app.war -DgroupId=your.groupId -DartifactId=your-artifactId -Dversion=1.0 -Dpackaging=war -DgeneratePom=true'
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
