FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-0.0.1-SNAPSHOT.jar spring-boot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-0.0.1-SNAPSHOT.jar"]

#  docker run -p 9090:8080 spring-boot-poc --name spring-boot-container
