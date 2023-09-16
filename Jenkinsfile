pipeline {
    agent any
    tools {
        maven 'maven_3_5_0'
    }

     environment {
        DOCKER_USERNAME = 'yogesh860'
        DOCKER_PASSWORD = 'Yogesh123'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout([scm: [$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/DewadeYogesh/dockerImage']]]])
                bat 'mvn clean install'
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    bat 'docker build -t yogesh860/devops-integration .'
                }
            }
        }

        stage('Docker Login') {
            steps {
                script {

                    def loginCmd = "echo '\${DOCKER_PASSWORD}' | docker login -u '\${DOCKER_USERNAME}' --password-stdin"
                    bat returnStatus: true, script: loginCmd
                }
            }
        }

        stage('Push Docker image') {
            steps {
                script {
                    bat 'docker push yogesh860/devops-integration'
                }
            }
        }
        stage('deploy to kubernete'){
        steps{
        script{
        kubernetesDeploy (configs: 'deployementservice.yaml',kubeconfigId: 'kubernetepwd')
        }

        }
        }
    }
}
