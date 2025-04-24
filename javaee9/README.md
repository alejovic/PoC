Java EE 8 to Jakarta EE 9 Migration Guide
---
Java EE 9 (Jakarta EE 9) was officially released in December 2020.

The transition from Java EE 8 to Jakarta EE 9 represents a significant milestone in the platform's evolution. After Oracle transferred Java EE to the Eclipse Foundation, it was renamed to Jakarta EE, with version 9 being the first major release under the new stewardship.
Major Changes from Java EE 8 to Jakarta EE 9
The most significant change in Jakarta EE 9 is the namespace migration:

* All package names changed from `javax.*` to `jakarta.*`
* API signatures remained functionally identical
* This change was necessary due to Oracle retaining the rights to the "`javax`" namespace

Other important changes:

* Several deprecated features were removed
* No major new functionality was added (Jakarta EE 9 focused on the namespace transition)
* Application servers were updated to support the new namespace

---

### Key Features in Java EE 9:
* Namespace Change: Migration from `javax.*` to `jakarta.*.`
* Simplified: Pruned deprecated APIs to modernize the stack.
* Aligned with Java SE 11+: It focuses on modern Java versions.
* Platform for Cloud-Native: Enhanced for microservices and cloud deployments.

### Relevant Libraries/Specs:
* Jakarta Servlet: For handling HTTP requests.
* Jakarta RESTful Web Services (JAX-RS): For REST APIs.
* Jakarta Persistence (JPA): For database interactions.
* Jakarta CDI (Contexts and Dependency Injection): For dependency management.
* Jakarta EJB (Enterprise JavaBeans): Business logic.
* Jakarta WebSocket, Jakarta Security, etc.

### Application Servers Supporting Java EE 9:
* Eclipse GlassFish 6.x
* Payara 6.x
* WildFly 23+ (still in transition for full Jakarta EE 9 support)
* OpenLiberty 21.x

## Specifications and Versions in Jakarta EE 9

| Specification                                     | Version     | Artifact Name                                       |
|--------------------------------------------------|-------------|----------------------------------------------------|
| Jakarta EE Platform                              | 9.0         | `jakarta.jakartaee-api:9.0.0`                      |
| Jakarta Servlet                                  | 5.0         | `jakarta.servlet-api:5.0.0`                        |
| Jakarta Server Pages (JSP)                       | 3.0         | `jakarta.jsp-api:3.0.0`                            |
| Jakarta Expression Language (EL)                 | 4.0         | `jakarta.el:jakarta.el-api:4.0.0`                  |
| Jakarta Standard Tag Library (JSTL)              | 2.0         | `jakarta.servlet.jsp.jstl-api:2.0.0`               |
| Jakarta Faces (JSF)                              | 3.0         | `jakarta.faces:jakarta.faces-api:3.0.0`            |
| Jakarta RESTful Web Services (JAX-RS)            | 3.0         | `jakarta.ws.rs:jakarta.ws.rs-api:3.0.0`            |
| Jakarta WebSocket                                | 2.0         | `jakarta.websocket:jakarta.websocket-api:2.0.0`    |
| Jakarta JSON Processing (JSON-P)                 | 2.0         | `jakarta.json:jakarta.json-api:2.0.0`              |
| Jakarta JSON Binding (JSON-B)                    | 2.0         | `jakarta.json.bind:jakarta.json.bind-api:2.0.0`    |
| Jakarta Persistence (JPA)                        | 3.0         | `jakarta.persistence:jakarta.persistence-api:3.0.0`|
| Jakarta Transactions (JTA)                       | 2.0         | `jakarta.transaction:jakarta.transaction-api:2.0.0`|
| Jakarta CDI (Contexts and Dependency Injection)  | 3.0         | `jakarta.enterprise.cdi-api:3.0.0`                 |
| Jakarta DI (Dependency Injection)                | 2.0         | `jakarta.inject:jakarta.inject-api:2.0.0`          |
| Jakarta Interceptors                             | 2.0         | `jakarta.interceptor:jakarta.interceptor-api:2.0.0`|
| Jakarta Enterprise Beans (EJB)                   | 4.0         | `jakarta.ejb:jakarta.ejb-api:4.0.0`                |
| Jakarta Mail                                     | 2.0         | `jakarta.mail:jakarta.mail-api:2.0.0`              |
| Jakarta Security                                 | 2.0         | `jakarta.security:jakarta.security-api:2.0.0`      |
| Jakarta Authentication                           | 2.0         | `jakarta.authentication:jakarta.authentication-api:2.0.0` |
| Jakarta Authorization                            | 2.0         | `jakarta.authorization:jakarta.authorization-api:2.0.0` |
| Jakarta Batch Processing                         | 2.0         | `jakarta.batch:jakarta.batch-api:2.0.0`            |


## This Project
Demonstrates:
- A simple REST API using **JAX-RS**.
- A stateless business bean using **EJB**.
- A simple web page using **JSF**.
- Dependency Injection with **CDI**.

## Running locally
1. Build the WAR: `mvn clean package`
2. Deploy it to a Java EE 9 server (e.g., Payara Server 6).

## Building and Running with Docker
Build your Java EE application first:
```
mvn clean package
```
Build the Docker image:
```
docker build -t javaee9-app .
```
Run with Docker Compose:
```
docker-compose up
```

## Access your application:

* Web interface: http://localhost:8080/javaee9-demo/
* REST API: http://localhost:8080/javaee9-demo/api/products
```shell
curl -X POST http://localhost:8080/javaee9-demo/api/products \
     -H "Content-Type: application/json" \
     -d '{"description":"Product Test","name":"Test","price":999.99}'
     
curl http://localhost:8080/javaee9-demo/api/products/1

curl http://localhost:8080/javaee9-demo/api/products
```
* Admin console: http://localhost:8080:4848 (admin/admin)
