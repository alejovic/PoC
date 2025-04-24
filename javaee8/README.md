# Java EE 8 Full Demo

## Summary
Java EE 8 (Enterprise Edition 8) is a platform for building modern, scalable, distributed Java applications. Released in September 2017, it includes APIs for REST, JSON processing, dependency injection, and more.

## History
- Born as J2EE 1.2 (1999).
- Simplified in Java EE 5 (annotations over XML).
- Java EE 7 (2013) brought REST, WebSocket, JSON-P.
- Java EE 8 (2017) improved web standards and moved towards microservices.
- After 2017, Java EE was transitioned to Eclipse Foundation and renamed Jakarta EE.

## Key APIs
- **JAX-RS 2.1**: REST APIs.
- **Servlet 4.0**: HTTP/2 support.
- **JSF 2.3**: Frontend (MVC UI framework).
- **CDI 2.0**: Dependency Injection.
- **EJB 3.2**: Business logic and transactions.
- **JSON-P/JSON-B**: JSON processing.
- **Security API**: Standardized security.

## Application Servers
- WildFly 18+
- Payara Server 5
- GlassFish 5
- WebLogic Server 12c
- TomEE 8

## This Project
Demonstrates:
- A simple REST API using **JAX-RS**.
- A stateless business bean using **EJB**.
- A simple web page using **JSF**.
- Dependency Injection with **CDI**.

## Running locally
1. Build the WAR: `mvn clean package`
2. Deploy it to a Java EE 8 server (e.g., Payara Server 5).

## Building and Running with Docker
Build your Java EE application first:
```
mvn clean package
```
Build the Docker image:
```
docker build -t javaee8-app .
```
Run with Docker Compose:
```
docker-compose up
```

## Access your application:

* Web interface: http://localhost:8080/javaee8-demo/
* REST API: http://localhost:8080/javaee8-demo/api/products
```shell
curl -X POST http://localhost:8080/javaee8-demo/api/products \
     -H "Content-Type: application/json" \
     -d '{"description":"Product Test","name":"Test","price":999.99}'
     
curl http://localhost:8080/javaee8-demo/api/products/1

curl http://localhost:8080/javaee8-demo/api/products
```
* Admin console: http://localhost:8080:4848 (admin/admin)
