## 配置

再maven的settings.xml配置文件中，有几个关于配置的问题记录一下

### server标签

 这是server的id（注意不是用户登陆的id），该id与distributionManagement中repository元素的id相匹配。

```
<settings>
  <servers>
    <server>
      <id>release</id>
      <username>myusername</username>
      <password>mypassword</password>
    </server>
    <server>
      <id>snapshot</id>
      <username>myusername</username>
      <password>mypassword</password>
    </server>
  </servers>
</settings>
```

其中 `server` 标签用于存储服务器的相关信息，包括服务器的用户名和密码等。这样，当 Maven 需要访问这些服务器时，它就可以使用这些凭据来进行身份验证。

### mirror标签

它用于为特定的仓库定义一个镜像，并告诉 Maven 在构建过程中应该使用哪个镜像。这样，当 Maven 需要访问特定仓库时，它可以直接访问镜像，而不是原始的仓库。

这有助于提高构建的效率，因为访问镜像通常比访问原始仓库更快。此外，如果原始仓库不可用，Maven 也可以继续通过镜像访问所需的资源。

```
<mirrors>
  <mirror>
    <id>my-mirror</id>
    <mirrorOf>central</mirrorOf>
    <url>http://mymirror.com/maven2/</url>
  </mirror>
</mirrors>

```

在这个示例中，我们定义了一个名为 `my-mirror` 的镜像，并告诉 Maven 在访问 `central` 仓库时使用这个镜像。这样，当 Maven 需要访问 `central` 仓库时，它会直接访问 `http://mymirror.com/maven2/` 这个 URL。

### profile标签

- Q:repositories的作用是什么?

  A:repositories在maven中用于指定依赖的存储库，即maven从哪里下载依赖的jar包。maven有两种存储库类型：本地存储库和远程存储库。本地存储库存储在本地硬盘上，用于存储maven下载的依赖包，并供本地项目使用。远程存储库存储在远程服务器上，通常包含大量的依赖包，maven可以在需要时从这些远程存储库中下载依赖。在项目的pom.xml文件中，可以通过配置repositories来指定远程存储库的地址，以便maven能够正确下载依赖包。

  ```
  <distributionManagement>
    <repository>
      <!-- 和settings文件中一致>
      <id>my-repo</id>
      <name>My Repository</name>
      <url>http://myrepo.com/repository</url>
    </repository>
  </distributionManagement>
  ```

  

- Q:repository.id作用

  A:repository.id是maven的一个配置项，用于为存储库指定一个唯一的标识。通常，在pom.xml文件中，可以通过<id>标签配置repository.id来指定存储库的唯一标识。在项目依赖了多个存储库时，使用repository.id可以方便地区分不同的存储库。此外，在设置maven的settings.xml文件时，可以通过repository.id配置存储库的默认配置，例如默认的仓库路径和插件配置。

  ```xml
  <project>
    ...
    <repositories>
      <repository>
        <id>central</id>
        <name>Central Repository</name>
        <url>http://central.maven.org/maven2</url>
      </repository>
    </repositories>
    ...
  </project>
  ```

  在上面的配置中，我们指定了一个存储库的配置信息，包括repository.id、存储库名称和存储库的URL地址。在项目运行时，maven会根据这些信息从http://central.maven.org/maven2这个地址下载依赖包。

- Q:如果不配置profiles maven可以正常打包吗?

  A:如果不配置profiles，maven仍然可以正常打包。在没有配置profiles的情况下，maven会使用默认的配置信息来打包项目。例如，maven会使用默认的本地存储库和远程存储库，并使用默认的构建插件来打包项目。
  
- Q: 如何进行多环境配置

  A:Maven 的 settings.xml 文件可以用来配置不同的运行环境，并切换不同的配置选项。要配置多个运行环境，你需要在 settings.xml 文件中定义一组运行环境，然后使用 `-D` 选项指定要使用的运行环境。例如：

  ```
  <!-- settings.xml -->
  <profiles>
    <profile>
      <id>development</id>
      <properties>
        <env>development</env>
      </properties>
    </profile>
    <profile>
      <id>production</id>
      <properties>
        <env>production</env>
      </properties>
    </profile>
  </profiles>
  ```

  ```
  # 执行 Maven 命令时指定运行环境
  mvn clean package -Denv=development
  ```

  在你的 POM 文件中，你可以通过 `${env}` 来引用当前的运行环境。例如：

  ```
  <!-- pom.xml -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.2.0</version>
        <configuration>
          <finalName>my-project-${env}</finalName>
        </configuration>
      </plugin>
    </plugins>
  </build>
  ```

  当你执行 `mvn clean package -Denv=development` 时，Maven 会使用 `my-project-development` 作为最终生成的 jar 包的名称。

### 我的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">


    <servers>
        <server>
            <!--这是server的id（注意不是用户登陆的id），该id与distributionManagement中repository元素的id相匹配。 -->
            <id>release</id>
            <username>devlop</username>
            <password>home</password>
        </server>

        <server>
            <id>snapshot</id>
            <username>develop</username>
            <password>home</password>
        </server>
    </servers>


    <mirrors>
        <mirror>
            <id>aliyun</id>
            <name>阿里云仓库地址</name>
            <!--以后向central这个仓库发的请求都会发到url-->
            <url>http://maven.aliyun.com/nexus/content/groups/public</url>
            <!--是要替代的仓库的id,如果填*，就会替代所有仓库。-->
            <mirrorOf>*</mirrorOf>
        </mirror>

    </mirrors>


    <profiles>
        <profile>
            <!--profile 的 id-->
            <id>nexus</id>
            <repositories>
                <!--结合pom使用-->
                <repository>
                    <!--仓库 id，repositories 可以配置多个仓库，保证 id 不重复-->
                    <id>nexus</id>
                    <!--仓库地址，即 nexus 仓库组的地址-->
                    <url>http://192.168.195.160:8091/repository/maven-public/</url>
                    <!--是否下载 releases 构件-->
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <!--是否下载 snapshots 构件-->
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
            <pluginRepositories>
                <!-- 插件仓库，maven 的运行依赖插件，也需要从私服下载插件 -->
                <pluginRepository>
                    <!-- 插件仓库的 id 不允许重复，如果重复后边配置会覆盖前边 -->
                    <id>nexus</id>
                    <name>repository</name>
                    <url>http://192.168.195.160:8091/repository/maven-public/</url>
                    <!--是否下载 releases 构件-->
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <!--是否下载 snapshots 构件-->
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </pluginRepository>
            </pluginRepositories>
        </profile>

    </profiles>

    <activeProfiles>
        <activeProfile>nexus</activeProfile>
    </activeProfiles>

    <!--始终更新snapshot构件-->
    <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
    </snapshots>

</settings>

```

