pipeline{
	agent any
	
	stages{
		stage('Compile Stage'){
			steps{
				withMaven(maven : 'maven3.6'){
					sh 'mvn clean compile'
					
								
				}
			}
		
		}
		
		stage('Testing Stage'){
			steps{
				withMaven(maven : 'maven3.6'){
					sh 'mvn test'
					
								
				}
			}
		
		}
		
		stage('Deployment Stage'){
			steps{
				withMaven(maven : 'maven3.6'){
					sh 'mvn deploy'
					
								
				}
			}
		
		}
	
	}
}