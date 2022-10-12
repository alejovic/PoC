#!/bin/bash

# chmod +x jenkins-spring-boot.sh
echo "running Jenkins-spring-boot-PoC"

mvn -f "/mnt/data/workspace/DEV/PoC/spring-boot/pom.xml" install

echo "running Jenkins-spring-boot-PoC. Finished"