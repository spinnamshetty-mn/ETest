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
                
                    echo "diploying to server"
                
            }
        }
    }
}
 post {
        always {
       mail bcc: 'foo@example.com', body: 'Test CC Pipeline', cc: 'xyz@example.com', from: '', replyTo: '', subject: 'Testing CC', to: 'abc@example.com',
             subject: "Pipeline Epidemic-TTT",
             body: "Epidemic-TTT Jenkins"
    }
}
