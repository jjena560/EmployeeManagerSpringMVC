pipeline{
	agent any
	tools{
		maven 'Maven'
		jdk 'jdk-11'
		}
		
	environment {
       env.PATH += ";c:\\Windows\\System32"
   }
		 
	stages {
		stage ("initialize") {
			steps {
			bat '''
			echo "PATH = ${PATH}"
			echo "M2_HOME = ${M2_HOME}"
			'''
			}
		
		}
	
	
	
        stage('build') {
            steps {
            	withMaven(maven : 'Maven'){
					echo 'Hello this is build'
                	bat 'mvn install'
					
								
				}
                
            }
        }
        
        stage('Testing Stage'){
			steps{
				withMaven(maven : 'Maven'){
					bat 'mvn test'
					
								
				}
			}
		
		}
		
		stage('Deployment Stage'){
			steps{
				withMaven(maven : 'Maven'){
					bat 'mvn deploy'
					
								
				}
			}
		
		}
    }
}