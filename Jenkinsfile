pipeline {
    agent any

    tools {
        jdk 'jdk-17'
    }

    environment {
        GRADLE_OPTS = '-Dorg.gradle.daemon=false'
        HEADLESS = 'true'
        BROWSER = 'chrome'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ShiwaliTyagi/serenity-parabank-automation.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                // Set Serenity-specific system properties for headless chrome
                sh './gradlew clean test aggregate -Dwebdriver.driver=chrome -Dheadless.mode=true -Dchrome.switches="--no-sandbox,--disable-dev-shm-usage"'
            }
        }
    }

    post {
        always {
            echo "Archiving Serenity reports..."
            junit '**/target/site/serenity/serenity-junit-results/*.xml'
            archiveArtifacts artifacts: '**/target/site/serenity/**/*.*', fingerprint: true
        }
        failure {
            echo "Build failed! Check the Serenity Report for test failure details."
        }
    }
}
