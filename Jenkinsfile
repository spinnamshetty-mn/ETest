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
        mail to: 'pkushwaha@modeln.com', 'sgunturu@modeln.com','spinnamshetty@modeln.com',
             subject: "Pipeline Epidemic-TTT",
             body: "Epidemic-TTT Jenkins "
    }
}
