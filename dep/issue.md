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

   