# Use the official Payara Server image to run the application
FROM payara/server-full:6.2023.9-jdk17

# Environment variables
ENV DEPLOYMENT_DIR ${DEPLOY_DIR}
#ENV DEPLOYMENT_DIR /opt/payara/appserver/glassfish/domains/domain1/autodeploy
ENV WAR_FILE javaee9-demo.war

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
                deploy --contextroot javaee9-demo --name javaee9-demo $DEPLOY_DIR/javaee9-demo.war && \
    asadmin stop-domain

# Expose the default HTTP port
EXPOSE 8080

CMD ["asadmin", "start-domain", "--verbose"]