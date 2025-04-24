# Use the official Apache TomEE 9 (Jakarta EE 9) Web Profile image
FROM tomee:9.1.0-webprofile

# Set environment variables
ENV WAR_FILE javaee9-demo.war

# Copy your custom manager.xml to override the default access restriction
COPY tomee/manager.xml /usr/local/tomee/conf/Catalina/localhost/manager.xml

# Add admin user for Manager App
COPY tomee/tomcat-users.xml /usr/local/tomee/conf/tomcat-users.xml

# Copy your WAR file into the TomEE webapps directory
COPY target/${WAR_FILE} /usr/local/tomee/webapps/${WAR_FILE}

# Expose HTTP port
EXPOSE 8080

# Default command
CMD ["catalina.sh", "run"]