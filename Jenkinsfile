pipeline {
    agent any
    tools {
        maven:""
    }
    stages {

        stage("Build Stage") {
            steps {
                echo 'Building...'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage("Deploy Stage") {
            steps {
                echo "Deploying..."
                sh 'scp -v -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/ubuntu-jenkins.pem target/*.jar ubuntu@13.232.62.87:/home/ubuntu'
                sh "ssh -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/ubuntu-jenkins.pem ubuntu@13.232.62.87 '/home/ubuntu/startup.sh'"
            }
        }
    }
}