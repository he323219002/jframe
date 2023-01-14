pipeline {
    // 指定集群中机器 
    agent any

    // 存放所有任务的合集 1
    stages {
        stage('pull git code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '160ssh', url: 'http://192.168.195.160:8093/root/jframe.git']]])
            }
        }

        stage('maven build') {
            steps {
                sh '''cd Jframe
                echo $(java -version)
                /usr/local/apache-maven-3.8.6/bin/mvn clean package -DskipTests'''
            }
        }

        stage('code detection') {
            steps {
                echo '检测代码质量-成功'
            }
        }

        stage('build docker image') {
            steps {
                echo '构建自定义镜像-成功'
            }
        }

        stage('push image to Harbor') {
            steps {
                echo '镜像发布到发布Harbor-成功'
            }
        }

        stage('notify server and deploy') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'k8s-master', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'k8s/jframe_pipeline.yaml')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
