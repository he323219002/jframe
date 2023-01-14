---
typora-root-url: ..\..\pic
---

## 安装

我安装的是最新版的jenkins，环境要求java11 + 

### 遇到的问题

#### 安装

按照官网教程，一直无法正常启动，本身环境为java 11，报错openjdk8无效

```
sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key
sudo yum upgrade
# Add required dependencies for the jenkins package
sudo yum install java-11-openjdk
sudo yum install jenkins
```

解决方法：因为新版本jenkins已经不支持jdk8，所以要删除环境中的jdk8

```
yum list java* 

把所有jdk1.8的安装包全部删除
```

```
查看状态
systemctl status jenkins

jenkins启动

#service jenkins start

重启

#service jenkins restart
停止

#service jenkins stop
```

#### github流水线建立

（国内用户强烈建议用私服的gitlab，或者gitee，gitlab会有时候出现 访问相关问题）

创建github流水线的时候，设置了凭据，但是一直失败。报错

```
stderr: fatal: TCP connection reset by peer
```

下载了一个插件 blue ocean解决了此问题，参考文档：https://blog.51cto.com/zq2599/5768354

## CI/CD 

### 插件安装

安装插件

- git Parameter
- publish over ssh

### 系统配置-连接远程目标服务器

通过ssh-key，连接需要部署的服务器

1. 在jenkins所在的服务器输入，` ssh-keygen -t rsa` 在~/.ssh目录下生成公钥和私钥
2. 在远程目标服务器的`~/.ssh`目录下新建`authorized_keys`文件，并把第一步的公钥复制进去
3. 在jenkins界面配置如下内容，并且将私钥复制

![](/微信截图_20230102194624.png)



### 流水线语法

```
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
```

### 流水线配置

#### JenkinsFile

将流水线语法部分的代码，复制到一个文件，命名为jenkinsFile，push到git仓库中，如果是github参见上方，github流水线建立。

![{3DD9217C-6319-452D-BDF7-023C86EB48CF}](/{3DD9217C-6319-452D-BDF7-023C86EB48CF}.png)

#### maven打包镜像

jenkinsFile流水线语法：

```
        stage('maven build') {
            steps {
                sh '''cd Jframe
                echo $(java -version)
                /usr/local/apache-maven-3.8.6/bin/mvn clean package -DskipTests'''
            }
        }
```

此处我遇到的问题是maven打包失败，看报错

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project basic: Fatal error compiling: error: invalid target release: 17 -> [Help 1]
```

原因是配置文件中的编译版本是jdk17，但是maven运行的打包命令不支持，此处需要修改jenkins全局环境变量，指定我的jdk版本。

![](/{543E940D-216A-4F7C-A2C2-0420D12C77DE}.png)

#### 上传镜像到docker仓库

参考文档：镜像上传Harbor  https://blog.csdn.net/weixin_37194108/article/details/106248700

#### k8s拉取镜像部署

1. 准备工作：k8s集群中每台机器都需要docker login一下私服，输入账号密码就可以。

2. 在集群中配置docker的secret，我用的是可视化界面kuboard操作（第三步的配置文件会用到）![](/{C871343C-FD9A-48AD-A0D6-F56E5418F8AB}.png)

3. 准备配置文件

   ```yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     namespace: jframe
     name: jframe-dep
     labels:
       app: jframeL
   spec:
     replicas: 2
     selector:
       matchLabels:
         app: jframeL
     template:
       metadata:
         labels:
           app: jframeL    
       spec:
         imagePullSecrets:
         - name: harbor
         containers:
         - name: jframe
           image: 192.168.195.160:8092/repo/jframe:v1.0.0
           imagePullPolicy: Always
           ports:
           - containerPort: 8051
   ---
   apiVersion: v1
   kind: Service
   metadata:
     namespace: jframe
     labels:
       app: jframeL
     name: jframe-svc  
   spec:
     selector:
       app: jframeL
     ports:
     - port: 8081
       targetPort: 8051
   
     type: NodePort
   ---
   apiVersion: networking.k8s.io/v1
   kind: Ingress
   metadata:
     namespace: jframe
     name: jframe-ing 
   spec:
     ingressClassName: ingress
     rules:
     - host: jimmy.jframe.com
       http:
         paths:
         - path: /
           pathType: Prefix
           backend:
             service:
               name: jframe-svc
               port:
                 number: 8081
   ```

   

