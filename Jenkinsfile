pipeline {
    agent any
    tools {
        maven "mvn"
    }

    stages {
        stage('GitHub') {
            steps {
            git 'https://github.com/DzmitryRazhkou/OpenCart_Selenium.git'
            }
        }
    }

    stages {
        stage('Selenium Build') {
            steps {
                sh 'mvn clean test'
            }
            post {
                success {
                    allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                }

            }
        }
    }
}