pipeline {
  agent any
  tools {
    maven 'maven-3.8.5' 
  }

  options {
  timestamps ()
  buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '4')
  }

  stages {

   stage("Initial cleanup") {
        steps {
          dir("${WORKSPACE}") {
            deleteDir()
          }
        }
      }

  stage('Checkout SCM') {
    steps {
          git branch: 'master', credentialsId: 'git:a78d564b7e3823083a9092b5e9c7848dcd701c99dd20ae466e9a20691bf39f8e', url: 'https://TheCountt@bitbucket.org/thecountt/spring-petclinic.git'
      }
    }

  stage('Build') { 
    steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

  stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    // junit 'spring-petclinic/target/test-reports/*.xml'
                }
            }
        }

  // Scan Packaged code using sonarqube
  stage('SonarQube Quality Gate') {
      when { branch pattern: "^master*|^test*", comparator: "REGEXP"}
        environment {
          scannerHome = tool 'SonarQubeScanner'
        }
        steps {
            withSonarQubeEnv(credentialsId: 'token-sonarqube', installationName: 'sonarqube') {
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
            timeout(time: 5, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
               }
            }
         }

  stage('Build image') {
     environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
        REGISTRY = credentials('dockerhub')
        PATH = "$PATH:/usr/bin"
     }
     steps {
        sh "docker build -t anp/springboot:${env.BRANCH_NAME}-${TAG} ."
            }
        }
  
    







  }
}