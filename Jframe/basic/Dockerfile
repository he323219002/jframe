#基础镜像通过java17来的
FROM openjdk:17

COPY target/basic-0.0.1-SNAPSHOT.jar /usr/local/jframe/

ENTRYPOINT ["java","-jar","/usr/local/jframe/basic-0.0.1-SNAPSHOT.jar"]