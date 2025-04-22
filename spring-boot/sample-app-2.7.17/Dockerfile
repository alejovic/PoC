FROM openjdk:11
EXPOSE 8080
ADD target/sample-app-2.7.17-0.0.1-SNAPSHOT.jar sample-app-2.7.17-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev", "sample-app-2.7.17-0.0.1-SNAPSHOT.jar"]

# docker build -t spring-boot-poc-2.7.17 .
# docker run -p 9090:8080 spring-boot-poc-2.7.17 --name spring-boot-container-2.7.17

# pull to docker hub -> alejovic "user"
# docker login -u "alejovic" -p "*********" docker.io
# docker tag spring-boot-poc alejovic/spring-boot-poc
# docker push alejovic/spring-boot-poc
