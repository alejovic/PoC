# Proof of Concept - [Dropwizard]

# Dropwizard
Dropwizard is a Java framework for developing RESTful web services. It combines several well-known libraries into a simple, lightweight package that makes it easy to get started with building web applications.

# Getting Started
Currently, the latest version of Dropwizard is v4.0.13
You can find the latest version on the [Dropwizard website](https://www.dropwizard.io/).

```sh
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes \
-DarchetypeArtifactId=java-simple \
-DarchetypeVersion=[REPLACE WITH A VALID DROPWIZARD VERSION]
```

How to start the dropwizard application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/dropwizard-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

---

# 📈 Dropwizard Versions vs Java Versions

| Dropwizard Version | Java Version Supported | Notes |
|:-------------------|:------------------------|:------|
| **2.x** | Java 8, Java 11 | Officially targeted Java 8; Java 11 worked too |
| **3.x** | Java 11+ | Requires Java 11 minimum |
| **4.x (latest, dev)** | Java 17+ | Targets Java 17 officially |


