# Harbor

### 镜像推送

1. 推送镜像格式：harbor地址/项目名称/镜像名:版本

   ```
   docker tag imageId harbor地址/项目名称/镜像名:版本
   ```

2. 在服务端/etc/docker/daemon.json添加配置

   ```
   {
       "insecure-registries":[haobor地址]
   }
   ```

3. 重启docker服务

   ```
   systemctl restart docker
   ```

4. docker push

   ```
   docker push imageName(第一步的名称)
   ```

   

