pipeline{
	agent any
	tools{
		maven 'Maven'
		jdk 'jdk-11'
		}
		 
	stages {
		stage ("initialize") {
			steps {
			sh '''
			echo "PATH = ${PATH}"
			echo "M2_HOME = ${M2_HOME}"
			'''
			}
		
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