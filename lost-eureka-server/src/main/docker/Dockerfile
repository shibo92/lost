#下载java8的镜像
FROM java:8
#将本地文件挂到到/tmp目录
VOLUME /tmp
#复制文件到容器
ADD lost-eureka-server-0.0.1-SNAPSHOT.jar /lost-eureka-server.jar
#暴露端口
# EXPOSE 8761
#配置启动容器后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/lost-eureka-server.jar"]