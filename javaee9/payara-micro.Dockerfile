# Use the official Payara Server image to run the application
FROM payara/micro:6.2022.1-jdk11

# Environment variables
ENV DEPLOYMENT_DIR ${DEPLOY_DIR}
ENV WAR_FILE javaee9-demo.war

# Copy the WAR file to the deployment directory
COPY target/${WAR_FILE} $DEPLOY_DIR

# Copy custom asadmin script
COPY payara/setup-payara.asadmin ${HOME_DIR}/setup-payara.asadmin

# Execute the script on boot
CMD ["--deploy", "/opt/payara/deployments/javaee9-demo.war", "--postbootcommandfile", "/opt/payara/setup.asadmin"]