# K8S_NACOS集群搭建

## 安装步骤

建议先看下大概步骤，看看你是否也遇到过类似的报错，

master（192.168.195.100），node1（192.168.195.101），node2（192.168.195.102）如果配置文件中有相应的地址请改成自己对应的节点地址。

1. 参考官网部署k8s-nacos集群：https://nacos.io/zh-cn/docs/use-nacos-with-kubernetes.html，参见该文档中高级使用部分。遇到nfs-client一直启动不起来问题。到第2步

2. 解决nfs问题：https://juejin.cn/post/7056580934639812639

3. 继续下一个问题：只出现一个nacos-0，并且状态是Pending  ，解决方法：https://github.com/nacos-group/nacos-k8s/issues/263，简单来说就是需要根据日志建立对应的空文件夹。

4. 安装一个ingress来访问刚刚建立的nacos-headless服务，后面附上yaml文件，（参见9）

5. 上面问题都解决了之后，还是发现我的k8s对应的地址无法访问，原因是没有安装nginx-ingress-controller，解决方法：https://blog.csdn.net/fclwd/article/details/123603559，后面附上我的deploy.yaml（参见8），去掉了nodeSelector对应的name标签

6. 因为nacos官网是拉取了一个mysql镜像，生成一个service去做nacos配置的数据持久化，我想改成外置的mysql，解决方法：

   1. nacos对应的脚本 https://github.com/alibaba/nacos/blob/develop/distribution/conf/mysql-schema.sql。
   2. 配置好对应的deployment和service https://www.woniusnail.com/?p=1691

7. 主机配置ingress对应的host地址，访问可以成功。（配置ingress的时候，如果出现default-http-backend的相关问题，可以参见 https://www.cnblogs.com/askajohnny/p/16160721.html）

8. nginx-ingress-controller对应的deploy.yaml

   ```yaml
   #GENERATED FOR K8S 1.20
   apiVersion: v1
   kind: Namespace
   metadata:
     labels:
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/name: ingress-nginx
     name: ingress-nginx
   ---
   apiVersion: v1
   automountServiceAccountToken: true
   kind: ServiceAccount
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx
     namespace: ingress-nginx
   ---
   apiVersion: v1
   kind: ServiceAccount
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade,post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
     namespace: ingress-nginx
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: Role
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx
     namespace: ingress-nginx
   rules:
   - apiGroups:
     - ""
     resources:
     - namespaces
     verbs:
     - get
   - apiGroups:
     - ""
     resources:
     - configmaps
     - pods
     - secrets
     - endpoints
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - ""
     resources:
     - services
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingresses
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingresses/status
     verbs:
     - update
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingressclasses
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - ""
     resourceNames:
     - ingress-controller-leader
     resources:
     - configmaps
     verbs:
     - get
     - update
   - apiGroups:
     - ""
     resources:
     - configmaps
     verbs:
     - create
   - apiGroups:
     - ""
     resources:
     - events
     verbs:
     - create
     - patch
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: Role
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade,post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
     namespace: ingress-nginx
   rules:
   - apiGroups:
     - ""
     resources:
     - secrets
     verbs:
     - get
     - create
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: ClusterRole
   metadata:
     labels:
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx
   rules:
   - apiGroups:
     - ""
     resources:
     - configmaps
     - endpoints
     - nodes
     - pods
     - secrets
     - namespaces
     verbs:
     - list
     - watch
   - apiGroups:
     - ""
     resources:
     - nodes
     verbs:
     - get
   - apiGroups:
     - ""
     resources:
     - services
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingresses
     verbs:
     - get
     - list
     - watch
   - apiGroups:
     - ""
     resources:
     - events
     verbs:
     - create
     - patch
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingresses/status
     verbs:
     - update
   - apiGroups:
     - networking.k8s.io
     resources:
     - ingressclasses
     verbs:
     - get
     - list
     - watch
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: ClusterRole
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade,post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
   rules:
   - apiGroups:
     - admissionregistration.k8s.io
     resources:
     - validatingwebhookconfigurations
     verbs:
     - get
     - update
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: RoleBinding
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx
     namespace: ingress-nginx
   roleRef:
     apiGroup: rbac.authorization.k8s.io
     kind: Role
     name: ingress-nginx
   subjects:
   - kind: ServiceAccount
     name: ingress-nginx
     namespace: ingress-nginx
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: RoleBinding
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade,post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
     namespace: ingress-nginx
   roleRef:
     apiGroup: rbac.authorization.k8s.io
     kind: Role
     name: ingress-nginx-admission
   subjects:
   - kind: ServiceAccount
     name: ingress-nginx-admission
     namespace: ingress-nginx
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: ClusterRoleBinding
   metadata:
     labels:
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx
   roleRef:
     apiGroup: rbac.authorization.k8s.io
     kind: ClusterRole
     name: ingress-nginx
   subjects:
   - kind: ServiceAccount
     name: ingress-nginx
     namespace: ingress-nginx
   ---
   apiVersion: rbac.authorization.k8s.io/v1
   kind: ClusterRoleBinding
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade,post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
   roleRef:
     apiGroup: rbac.authorization.k8s.io
     kind: ClusterRole
     name: ingress-nginx-admission
   subjects:
   - kind: ServiceAccount
     name: ingress-nginx-admission
     namespace: ingress-nginx
   ---
   apiVersion: v1
   data:
     allow-snippet-annotations: "true"
   kind: ConfigMap
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-controller
     namespace: ingress-nginx
   ---
   apiVersion: v1
   kind: Service
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-controller
     namespace: ingress-nginx
   spec:
     externalTrafficPolicy: Local
     ipFamilies:
     - IPv4
     ipFamilyPolicy: SingleStack
     ports:
     - appProtocol: http
       name: http
       port: 80
       protocol: TCP
       targetPort: http
     - appProtocol: https
       name: https
       port: 443
       protocol: TCP
       targetPort: https
     selector:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/name: ingress-nginx
     type: LoadBalancer
   ---
   apiVersion: v1
   kind: Service
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-controller-admission
     namespace: ingress-nginx
   spec:
     ports:
     - appProtocol: https
       name: https-webhook
       port: 443
       targetPort: webhook
     selector:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/name: ingress-nginx
     type: ClusterIP
   ---
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-controller
     namespace: ingress-nginx
   spec:
     replicas: 1
     minReadySeconds: 0
     revisionHistoryLimit: 10
     selector:
       matchLabels:
         app.kubernetes.io/component: controller
         app.kubernetes.io/instance: ingress-nginx
         app.kubernetes.io/name: ingress-nginx
     template:
       metadata:
         labels:
           app.kubernetes.io/component: controller
           app.kubernetes.io/instance: ingress-nginx
           app.kubernetes.io/name: ingress-nginx
       spec:
         hostNetwork: true
         containers:
         - args:
           - /nginx-ingress-controller
           - --publish-service=$(POD_NAMESPACE)/ingress-nginx-controller
           - --election-id=ingress-controller-leader
           - --controller-class=k8s.io/ingress-nginx
           - --ingress-class=nginx
           - --configmap=$(POD_NAMESPACE)/ingress-nginx-controller
           - --validating-webhook=:8443
           - --validating-webhook-certificate=/usr/local/certificates/cert
           - --validating-webhook-key=/usr/local/certificates/key
           env:
           - name: POD_NAME
             valueFrom:
               fieldRef:
                 fieldPath: metadata.name
           - name: POD_NAMESPACE
             valueFrom:
               fieldRef:
                 fieldPath: metadata.namespace
           - name: LD_PRELOAD
             value: /usr/local/lib/libmimalloc.so
           image: registry.cn-hangzhou.aliyuncs.com/google_containers/nginx-ingress-controller:v1.1.1
           imagePullPolicy: IfNotPresent
           lifecycle:
             preStop:
               exec:
                 command:
                 - /wait-shutdown
           livenessProbe:
             failureThreshold: 5
             httpGet:
               path: /healthz
               port: 10254
               scheme: HTTP
             initialDelaySeconds: 10
             periodSeconds: 10
             successThreshold: 1
             timeoutSeconds: 1
           name: controller
           ports:
           - containerPort: 80
             name: http
             protocol: TCP
           - containerPort: 443
             name: https
             protocol: TCP
           - containerPort: 8443
             name: webhook
             protocol: TCP
           readinessProbe:
             failureThreshold: 3
             httpGet:
               path: /healthz
               port: 10254
               scheme: HTTP
             initialDelaySeconds: 10
             periodSeconds: 10
             successThreshold: 1
             timeoutSeconds: 1
           resources:
             requests:
               cpu: 100m
               memory: 90Mi
           securityContext:
             allowPrivilegeEscalation: true
             capabilities:
               add:
               - NET_BIND_SERVICE
               drop:
               - ALL
             runAsUser: 101
           volumeMounts:
           - mountPath: /usr/local/certificates/
             name: webhook-cert
             readOnly: true
         dnsPolicy: ClusterFirst
         nodeSelector:
           kubernetes.io/os: linux
         serviceAccountName: ingress-nginx
         terminationGracePeriodSeconds: 300
         volumes:
         - name: webhook-cert
           secret:
             secretName: ingress-nginx-admission
   ---
   apiVersion: batch/v1
   kind: Job
   metadata:
     annotations:
       helm.sh/hook: pre-install,pre-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission-create
     namespace: ingress-nginx
   spec:
     template:
       metadata:
         labels:
           app.kubernetes.io/component: admission-webhook
           app.kubernetes.io/instance: ingress-nginx
           app.kubernetes.io/managed-by: Helm
           app.kubernetes.io/name: ingress-nginx
           app.kubernetes.io/part-of: ingress-nginx
           app.kubernetes.io/version: 1.1.2
           helm.sh/chart: ingress-nginx-4.0.18
         name: ingress-nginx-admission-create
       spec:
         containers:
         - args:
           - create
           - --host=ingress-nginx-controller-admission,ingress-nginx-controller-admission.$(POD_NAMESPACE).svc
           - --namespace=$(POD_NAMESPACE)
           - --secret-name=ingress-nginx-admission
           env:
           - name: POD_NAMESPACE
             valueFrom:
               fieldRef:
                 fieldPath: metadata.namespace
           image: registry.cn-hangzhou.aliyuncs.com/google_containers/kube-webhook-certgen:v1.1.1
           imagePullPolicy: IfNotPresent
           name: create
           securityContext:
             allowPrivilegeEscalation: false
         nodeSelector:
           kubernetes.io/os: linux
         restartPolicy: OnFailure
         securityContext:
           fsGroup: 2000
           runAsNonRoot: true
           runAsUser: 2000
         serviceAccountName: ingress-nginx-admission
   ---
   apiVersion: batch/v1
   kind: Job
   metadata:
     annotations:
       helm.sh/hook: post-install,post-upgrade
       helm.sh/hook-delete-policy: before-hook-creation,hook-succeeded
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission-patch
     namespace: ingress-nginx
   spec:
     template:
       metadata:
         labels:
           app.kubernetes.io/component: admission-webhook
           app.kubernetes.io/instance: ingress-nginx
           app.kubernetes.io/managed-by: Helm
           app.kubernetes.io/name: ingress-nginx
           app.kubernetes.io/part-of: ingress-nginx
           app.kubernetes.io/version: 1.1.2
           helm.sh/chart: ingress-nginx-4.0.18
         name: ingress-nginx-admission-patch
       spec:
         containers:
         - args:
           - patch
           - --webhook-name=ingress-nginx-admission
           - --namespace=$(POD_NAMESPACE)
           - --patch-mutating=false
           - --secret-name=ingress-nginx-admission
           - --patch-failure-policy=Fail
           env:
           - name: POD_NAMESPACE
             valueFrom:
               fieldRef:
                 fieldPath: metadata.namespace
           image: registry.cn-hangzhou.aliyuncs.com/google_containers/kube-webhook-certgen:v1.1.1
           imagePullPolicy: IfNotPresent
           name: patch
           securityContext:
             allowPrivilegeEscalation: false
         nodeSelector:
           kubernetes.io/os: linux
         restartPolicy: OnFailure
         securityContext:
           fsGroup: 2000
           runAsNonRoot: true
           runAsUser: 2000
         serviceAccountName: ingress-nginx-admission
   ---
   apiVersion: networking.k8s.io/v1
   kind: IngressClass
   metadata:
     labels:
       app.kubernetes.io/component: controller
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: nginx
   spec:
     controller: k8s.io/ingress-nginx
   ---
   apiVersion: admissionregistration.k8s.io/v1
   kind: ValidatingWebhookConfiguration
   metadata:
     labels:
       app.kubernetes.io/component: admission-webhook
       app.kubernetes.io/instance: ingress-nginx
       app.kubernetes.io/managed-by: Helm
       app.kubernetes.io/name: ingress-nginx
       app.kubernetes.io/part-of: ingress-nginx
       app.kubernetes.io/version: 1.1.2
       helm.sh/chart: ingress-nginx-4.0.18
     name: ingress-nginx-admission
   webhooks:
   - admissionReviewVersions:
     - v1
     clientConfig:
       service:
         name: ingress-nginx-controller-admission
         namespace: ingress-nginx
         path: /networking/v1/ingresses
     failurePolicy: Fail
     matchPolicy: Equivalent
     name: validate.nginx.ingress.kubernetes.io
     rules:
     - apiGroups:
       - networking.k8s.io
       apiVersions:
       - v1
       operations:
       - CREATE
       - UPDATE
       resources:
       - ingresses
     sideEffects: None
   
   ```

9. ingress对应的yaml

   ```yaml
   apiVersion: networking.k8s.io/v1
   kind: Ingress
   metadata:
     name: nacos-ingress
     namespace: nacos
     annotations:
       kubernetes.io/ingress.class: "nginx"  
   spec:
     defaultBackend:
       service:
         name: default-http-backend
         port:
           number: 80
     rules:
       - host: nacos.jframe.com # 我主机配置的host
         http:
           paths:
             - pathType: Prefix
               path: /
               backend:
                 service:
                   name: nacos-headless
                   port:
                     number: 8848
   ```

## 为什么不使用HTTPS

1. 因为https意味着大部分场景需要放置到公网，nacos也明确表示配置文件应该是内部系统不应该暴露到公网。

2. 自身实验配置https后，遇到问题：无限重定向导致浏览器报错：重定向次数过多，原因是因为使用`/nacos`而不是`/nacos/`，nacos服务会将`/nacos`302重定向到`/nacos/`,但是再配置了https后：

   1. 会将路径重定向到HTTP协议 路径为`/nacos/`，这是正常转发，因为nginx会将https转为http访问。
   2. 但是配置了证书，所以http会308永久重定向到HTTPS`/nacos`

   此处导致1，2两步循环，使浏览器报错。如果nacos服务端能够接收/nacos路径，应该会解决第二个问题。

## k8s nacos集群 grpc通信问题

问题描述：我在项目中使用ingress代理的接口时候，因为只有域名，默认只会找8848这个端口，但是在nacos 2.0中，grpc通信的接口默认是8848+1000，这一层在ingress中无法实现，导致报错。

在github：k8s-nacos中遇到同样的issue：[k8s部署Nacos2.x](https://github.com/nacos-group/nacos-k8s/issues/291)

### 问题解决

1. 将暴露nacos的ingress删除，改用nodeport，将8848，9848，9849分别暴露出去。下面是我的nodeport配置

   ```yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: nacos-node-port
     namespace: nacos
     labels:
       app: nacos
   spec:
     selector:
       app: nacos
     externalTrafficPolicy: Cluster
     ports:
       - name: nacos-service-0
         targetPort: 8848
         nodePort: 30848 
         port: 8848
         protocol: TCP
       - port: 7848
         name: rpc
         targetPort: 7848
         nodePort: 30212
       - port: 9848
         name: client
         targetPort: 9848 
         nodePort: 31848 # 一定要比8848的nodeport+1000
       - port: 9849
         name: server
         targetPort: 9849
         nodePort: 31849 # 一定要比8848的nodeport+1000
     type: NodePort
   
   ```

2. 將項目中的bootstrap server addr修改

   ```yaml
   spring:
     cloud:
       nacos:
         discovery:
           server-addr: 192.168.195.100:30848
         config:
           server-addr: 192.168.195.100:30848
   ```


## issue

### K8S-nacos集群内部启动失败

https://github.com/nacos-group/nacos-k8s/issues/386
