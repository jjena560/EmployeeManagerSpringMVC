pipeline{
	agent any
	tools{
		maven 'Maven'
		jdk 'jdk-11'
		}
		

		 
	stages {
		stage ("initialize") {
			steps {
				bat 'mvn clean install'
			}
		
		}
	
	
	
    
		
		stage('Deployment Stage'){
			steps{
				echo 'deploy'
					
								
				}
			}
		
		}
    }
}
