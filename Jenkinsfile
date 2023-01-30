pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Running ${env.BUILD_ID} on ${env.JENKINS_URL}'
      }
    }

  }
  environment {
    BUILD_ID = '3'
    JENKINS_URL = 'www.test.com'
  }
}