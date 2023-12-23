pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }

        /*stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        
        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sq1') {
                    //я понимаю что не стоит сюда ставить apikey
                    bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_b0f7e155e403a19ffa3d631f40c8dcff88386aa0'
                }
            }
        }*/

        stage ('Archive Artifacts'){
            steps {
                archiveArtifacts artifacts: '**/target/*.war'
            }
        }
        
        stage('Deploy to Tomcat') {
            steps {
                    //sh 'mvn deploy:deploy-file -Durl=http://localhost:8101/manager/text -DrepositoryId=tomcat -Dfile=target/marketplace-app.war -DgroupId=your.groupId -DartifactId=your-artifactId -Dversion=1.0 -Dpackaging=war -DgeneratePom=true -Dtomcat.username=$TOMCAT_USERNAME -Dtomcat.password=$TOMCAT_PASSWORD'
                deploy adapters: [tomcat10(credentialsId: 'tomcat', path: '', url: 'http://localhost:8101/')], contextPath: 'app', war: 'target/*.war'
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

