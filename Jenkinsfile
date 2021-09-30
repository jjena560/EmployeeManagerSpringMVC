pipeline{
	agent any
	
	tools{
		maven 'Maven'
		jdk 'jdk-11'
		}
		
	
		 
	stages {
		stage ("initialize") {
			steps {
				echo 'mvn initialize'
			}
		
		}
		
		stage('Testing Stage'){
			steps{
				withMaven(maven : 'Maven'){
					echo 'mvn test'
					
								
				}
			}
		
		}
		
		stage('Deployment Stage'){
			steps{
				withMaven(maven : 'Maven'){
					echo 'mvn deploy'
					
								
				}
			}
		
		}
	}   
        
}
