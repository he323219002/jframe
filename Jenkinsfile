pipeline {
    // 指定集群中机器 
    agent any

    // 存放所有任务的合集 
    stages {
        stage('pull git code') {
            steps {
                echo '拉取Git代码-成功'
            }
        }

        stage('maven build') {
            steps {
                echo 'maven构建项目-成功'
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
                echo '通知目标服务器部署项目-成功'
            }
        }
    }
}
