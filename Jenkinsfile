pipeline{
	agent any
	tools{
		maven 'Maven'
	}
	
	stages {
        stage('build') {
            steps {
            	withMaven(maven : 'Maven'){
					echo 'Hello this is build'
                	sh 'mvn install'
					
								
				}
                
            }
        }
        
        stage('Testing Stage'){
			steps{
				withMaven(maven : 'Maven'){
					sh 'mvn test'
					
								
				}
			}
		
		}
		
		stage('Deployment Stage'){
			steps{
				withMaven(maven : 'Maven'){
					sh 'mvn deploy'
					
								
				}
			}
		
		}
    }
}