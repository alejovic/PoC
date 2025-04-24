# Use the official Payara Server image to run the application
FROM payara/server-full:5.2022.2-jdk11

# Environment variables
ENV DEPLOYMENT_DIR ${DEPLOY_DIR}
ENV WAR_FILE javaee8-demo.war

# Copy the WAR file to the deployment directory
COPY target/${WAR_FILE} $DEPLOY_DIR

# Copy custom asadmin script
COPY payara/setup-payara.asadmin ${HOME_DIR}/setup-payara.asadmin
COPY payara/password.txt ${HOME_DIR}/password.txt

# Run the script during image build
RUN asadmin start-domain && \
    asadmin --user $ADMIN_USER --passwordfile=$HOME_DIR/password.txt \
        --port 4848 --interactive=false \
        < ${HOME_DIR}/setup-payara.asadmin && \
    asadmin --user $ADMIN_USER --passwordfile=$HOME_DIR/password.txt \
                deploy --contextroot javaee8-demo --name javaee8-demo $DEPLOY_DIR/javaee8-demo.war && \
    asadmin stop-domain

# Expose the default HTTP port
EXPOSE 8080

CMD ["asadmin", "start-domain", "--verbose"]