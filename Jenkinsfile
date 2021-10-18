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
        mail to: 'pkushwaha@modeln.com,sgunturu@modeln.com,spinnamshetty@modeln.com',
             subject: " Pipeline: ${currentBuild.fullDisplayName}",
             body: "Build was done for ${env.BUILD_URL}"
    }
}
    
}


