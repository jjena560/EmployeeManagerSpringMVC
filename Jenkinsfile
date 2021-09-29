pipeline{
	agent any
	tools{
		maven 'Maven'
	}
	
	stages {
        stage('build') {
            steps {
                echo 'Hello this is build'
                sh 'mvn install'
            }
        }
    }
}