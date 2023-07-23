## 问题解决记录

1. common打包后，可以引用但是无法查看注释源码。 出现`Sources not found for: com.jframe.common:common:1.0-SNAPSHOT`。

   解决方式：在对应的pom中加入打包插件。

   ```xml
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-source-plugin</artifactId>
   <!--                <version>3.0.0</version>-->
                   <!-- 绑定source插件到Maven的生命周期,并在生命周期后执行绑定的source的goal -->
                   <executions>
                       <execution>
                           <!-- 绑定source插件到Maven的生命周期 -->
                           <phase>compile</phase>
                           <!--在生命周期后执行绑定的source插件的goals -->
                           <goals>
                               <goal>jar-no-fork</goal>
                           </goals>
                       </execution>
                   </executions>
               </plugin>
   ```

2. 自定义异常一直抛出空指针，获取不到输入的异常信息。

   解决方式：复写`RuntimeException`的getMessage方法：

   ```
       @Override
       public String getMessage() {
           return errorMsg;
       }
   ```

3. 自定义异常未被捕捉，前端页面一直是原生错误

   解决方式：启动类加上扫描包的地址

   ```
   @SpringBootApplication(scanBasePackages = {"com.jframe.basic","com.jframe.framework"})
   ```

4. 引入starter的bean未生效，巨坑，2.7之后有了新的配置方式，用原来的spring.factories可能不会生效，用下列方法可以生效

   ```
   在原来的META-INF下新建spring目录，继续新建org.springframework.boot.autoconfigure.AutoConfiguration.imports 文件
   在上述文件中放入要引入的configuration
   ```

4. 在maven编译中`${reversion}`未找到，且从引用的项目中看，reversion没有被转换为具体的版本号，导致编译无法找到

   ```
   在父pom中添加以下maven 插件配置，即可解决
               <plugin>
                   <groupId>org.codehaus.mojo</groupId>
                   <artifactId>flatten-maven-plugin</artifactId>
                   <version>1.2.1</version>
                   <configuration>
                       <!-- 避免IDE将 .flattened-pom.xml 自动识别为功能模块 -->
                       <flattenedPomFilename>pom-xml-flattened</flattenedPomFilename>
                       <updatePomFile>true</updatePomFile>
                       <flattenMode>resolveCiFriendliesOnly</flattenMode>
                   </configuration>
                   <executions>
                       <execution>
                           <id>flatten</id>
                           <phase>process-resources</phase>
                           <goals>
                               <goal>flatten</goal>
                           </goals>
                       </execution>
                       <execution>
                           <id>flatten.clean</id>
                           <phase>clean</phase>
                           <goals>
                               <goal>clean</goal>
                           </goals>
                       </execution>
                   </executions>
               </plugin>
   ```
   
6. mybatis plus报Invalid bound statement (not found):解决

   ```
   在启动类上新增注解@MapperScan(value = "com.jframe.basic",annotationClass = Mapper.class)
   原来注解为@MapperScan(basePackages = "com.jframe.basic")
   ```

   