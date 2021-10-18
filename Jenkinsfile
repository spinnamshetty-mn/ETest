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
        failure {
        mail to: 'pkushwaha@modeln.com', 'sgunturu@modeln.com','spinnamshetty@modeln.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
    }
}
