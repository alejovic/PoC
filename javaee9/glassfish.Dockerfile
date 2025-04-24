# Use the Eclipse GlassFish 6.2.5 (Jakarta EE 9) base image
FROM eclipse/glassfish:6.2.5-jdk11

# Set environment variables
ENV DEPLOY_DIR /opt/payara/deployments
ENV APP_NAME javaee9-demo.war

# Copy WAR file into autodeploy directory
COPY target/${APP_NAME} $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/

# Expose HTTP port
EXPOSE 8080

# Start the GlassFish server
CMD ["asadmin", "start-domain", "-v"]