pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Running ${env. BUILD_NUMBER} on ${env. JOB_URL}'
        sh 'printenv'
      }
    }

  }
  environment {
    BUILD_ID = '3'
    JENKINS_URL = 'www.test.com'
  }
}