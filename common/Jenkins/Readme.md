## 安装

我安装的是最新版的jenkins，环境要求java11 + 

### 遇到的问题

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

