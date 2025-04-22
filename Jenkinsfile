pipeline {
    agent any

    environment {
        // Set the Java Home if needed (optional)
        JAVA_HOME = tool name: 'jdk-17', type: 'jdk'  // Change if you're using a different version
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        // If you're using headless browser for execution
        CHROME_HEADLESS = "--headless --disable-gpu --window-size=1920,1080"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/ShiwaliTyagi/serenity-parabank-automation.git', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                sh './gradlew clean test aggregate'
            }
        }

        stage('Archive Test Reports') {
            steps {
                archiveArtifacts artifacts: 'target/site/serenity/**', fingerprint: true
            }
        }

        stage('Publish Serenity Report') {
            steps {
                publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Serenity Test Report'
                ])
            }
        }
    }

    post {
        always {
            junit '**/target/site/serenity/serenity-junit*.xml'
        }
        failure {
            echo "Build failed! Check the Serenity Report for test failure details."
        }
    }
}
