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

   