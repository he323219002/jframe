# K8S 实践

## K8S集群搭建

### 机器配置

- master：centos7、1C4G/20G
- node1: centos7、1C6G/30G（后续准备部署两套环境，所以设大一点）
- node2: centod7、1C4G/20G

### 版本信息

```
Client Version: version.Info{Major:"1", Minor:"21", GitVersion:"v1.21.2", GitTreeState:"clean", BuildDate:"2021-06-16T12:59:11Z", GoVersion:"go1.16.5", Compiler:"gc", Platform:"linux/amd64"}
Server Version: version.Info{Major:"1", Minor:"21", GitVersion:"v1.21.2",  GitTreeState:"clean", BuildDate:"2021-06-16T12:53:14Z", GoVersion:"go1.16.5", Compiler:"gc", Platform:"linux/amd64"}
```

### 安装步骤

才有kubeadm安装

参见：https://blog.csdn.net/qq_37481017/article/details/118897138，一次性成功。

尝试安装过1.24+版本，由于containered问题，报错信息一直是CNI一直没有初始化成功，导致集群一直init不成功，后面改成上述地址的docker安装成功。

#### 注意事项：

在安装calico网络插件的时候，需要改一下yaml中的镜像地址（之前是k8s开头的）

```
image: quay.io/calico/kube-controllers:v3.24.5
```

