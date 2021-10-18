pipeline{
    agent any
    stages{
        stage("Building"){
            steps{
        
                    sh "mvn clean compile"
                
            }
        }
        stage("Testing"){
            steps{
               
                    sh "mvn test"
                
            }
        }
        stage("Deploying"){
            steps{
                
                    echo "deploying to server"
                
            }
        }
    }
      post {
        always {
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }
    
}


