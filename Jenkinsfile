node {
    def maven = tool 'maven_3_5_4'

    stage('Clone Repository') {
        git url: 'https://github.com/josephakroush/aws-demo.git'
    }

    stage('Compile') {
        sh "${maven}/bin/mvn clean compile"
    }

    stage('Run Unit Tests') {
        sh "${maven}/bin/mvn test"
    }

    stage('Create Artifact') {
        sh "${maven}/bin/mvn package shade:shade"
    }

    stage('Deploy AWS Lambda') {
        withCredentials([[
            $class: 'AmazonWebServicesCredentialsBinding',
            credentialsId: 'aws-credentials',
            accessKeyVariable: 'AWS_ACCESS_KEY_ID',
            secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
        ]]) {
            deployLambda([
                alias: '',
                artifactLocation: './target/demo-1.0-SNAPSHOT.jar',
                awsAccessKeyId: AWS_ACCESS_KEY_ID,
                awsRegion: 'us-east-1',
                awsSecretKey: AWS_SECRET_ACCESS_KEY,
                deadLetterQueueArn: '',
                description: '',
                environmentConfiguration: [kmsArn: ''],
                functionName: 'helloWorld', handler: '',
                memorySize: '',
                role: '',
                runtime: 'java8',
                securityGroups: '',
                subnets: '',
                timeout: '',
                updateMode: 'code'
            ])
        }
    }
}
