# Use the official Maven image to build the Java EE 8 application
FROM maven:3.8.6-openjdk-11 AS build
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use the official Payara Server image to run the application
FROM payara/server-full:6.2022.1-jdk11

# Environment variables
ENV DEPLOYMENT_DIR ${DEPLOY_DIR}
ENV WAR_FILE javaee9-demo.war

# Copy the WAR file to the deployment directory
COPY --from=build target/${WAR_FILE} $DEPLOY_DIR
# Expose the default HTTP port
EXPOSE 8080

CMD ["asadmin", "start-domain", "--verbose"]
