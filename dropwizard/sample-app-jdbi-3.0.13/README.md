# Proof of Concept - [Dropwizard]

# Dropwizard 3.0.13 with JDBI
---

🧠 **What is org.jdbi.v3?**
JDBI stands for Java Database Interface.

It’s a wrapper around JDBC (Java Database Connectivity) that makes it easier to work with databases in Java.

* ✅ It makes it easy to execute SQL from Java
* ✅ It avoids a lot of boilerplate (like manually writing JDBC connection, statement, resultset handling, etc.)
* ✅ It maps query results into Java objects (POJOs) automatically
* ✅ It fits perfectly with Dropwizard — that's why Dropwizard has dropwizard-jdbi3 module built-in.

---

Upgrade to Dropwizard 3.x
---
Dropwizard 3.x introduces Java 17+ support, and you may see several changes in configuration and dependencies due to the upgrade. Below are the key changes and enhancements when moving to Dropwizard 3.x:

**Key Enhancements in Dropwizard 3.x**
---
**Java 17+ support:** Dropwizard 3.x supports Java 17+ (version 2.x supported Java 8/11).

**Dependency updates:** Major dependencies like Jackson, Jersey, and Logback have been updated to support newer features, security patches, and improvements.

**JDBI 3.x:** Dropwizard 3.x comes with improved integration with JDBI 3.x, a lightweight, flexible library for database access that simplifies handling SQL queries in Java, providing a much more modern API than Hibernate.

**Updated configuration:** Some configuration and default behaviors are now more aligned with modern standards, so you'll see minor changes in config.yml and how certain things are configured.


# ⚡ Characteristics of **Dropwizard 3.x**

1. **Java 11+ Support**  
   Dropwizard 3.x officially supports **Java 11 and higher**. Java 11 is the minimum required version, and Dropwizard fully leverages features available in Java 11+.

2. **Jersey 3.x Integration**  
   The 3.x series integrates with **Jersey 3.x**, which is the JAX-RS implementation for RESTful services. This provides improved functionality and performance.

3. **Improved Performance and Optimizations**  
   Dropwizard 3.x includes performance improvements over previous versions. This includes better handling of resources, faster startup times, and optimized configuration management.

4. **Hibernate 6.x and JDBI Support**  
   Dropwizard 3.x continues supporting **JDBI** for database operations and **Hibernate 6.x** for ORM capabilities. It includes updates for compatibility with the newer Hibernate version and other modern database technologies.

5. **Enhanced Security Features**  
   Dropwizard 3.x comes with improved **security features**, including better support for configuring HTTPS, CORS, and JWT-based authentication.

6. **Updated Dropwizard Metrics**  
   The **metrics** library, included in Dropwizard, is updated in 3.x to support the latest versions, enabling better performance monitoring and reporting for your applications.

7. **Improved Dropwizard Configuration**  
   Dropwizard 3.x provides better support for **configuration files** with enhanced parsing and validation, making it easier to configure your services and applications.

8. **Out-of-the-box Dependency Injection**  
   Dropwizard 3.x supports **basic dependency injection** using Jersey's **HK2** container, providing a lightweight DI mechanism. For more advanced DI, external frameworks like **Guice** or **Dagger** can be integrated.

---

# ⚡ Limitations / Drawbacks of **Dropwizard 3.0.13**

1. **No Full-fledged IoC Container**  
   Dropwizard 3.x does not include a full-fledged **Inversion of Control (IoC)** container like Spring’s **Spring Beans**. It provides basic DI through Jersey but lacks advanced features like AOP (Aspect-Oriented Programming), scopes, and lifecycle management.

2. **No WebSocket Support Out of the Box**  
   While Dropwizard supports HTTP/RESTful services, **WebSocket support** is not native to Dropwizard 3.x. You would need to implement WebSockets manually or use an external library for this functionality.

3. **Limited Ecosystem Compared to Spring**  
   While Dropwizard provides essential features for microservices, it lacks the extensive ecosystem that **Spring** provides, such as Spring Security, Spring Cloud, and Spring Batch.

4. **Configuration Complexity**  
   While Dropwizard's configuration mechanism is powerful, it can become complex in large applications with numerous configuration parameters. Dropwizard is less flexible than Spring when dealing with complex configurations.

5. **No Built-in Support for Frontend Frameworks**  
   Dropwizard is designed primarily as a backend framework, and it doesn't provide built-in support for frontend frameworks like **Spring MVC** or **Thymeleaf** for rendering views. It focuses mainly on RESTful APIs.

6. **No Native Microservices Features**  
   While Dropwizard can be used in microservice architectures, it doesn't include native features like **service discovery**, **circuit breakers**, or **distributed tracing** found in **Spring Cloud**. These would require external libraries to implement.

7. **Limited Support for Long-Running Processes**  
   Dropwizard is designed for building lightweight, high-performance applications, but it doesn’t provide advanced support for long-running processes or tasks (e.g., background jobs, scheduled tasks) as Spring does with **Spring Batch** or **Spring Scheduler**.

8. **Maturity and Stability**  
   Dropwizard 3.x is still evolving, and while it provides more modern features, its ecosystem might not be as mature or widely adopted as Spring, which could be a consideration when building large-scale applications.

9. **Backward Compatibility**  
   Dropwizard 3.x introduces some breaking changes compared to earlier versions (like 2.x), meaning migrating to version 3.x could require changes to existing codebases, which may be challenging for larger applications.

---

# 🧐 Realistic Use Cases

**When Dropwizard is great:**
- REST APIs
- Microservices
- Lightweight backend applications
- Internal tools and admin backends
- You like **simple**, **explicit** frameworks (less "magic" than Spring Boot)

**When Dropwizard might not be ideal:**
- Big, complex enterprise systems needing lots of modularity, dynamic beans
- Native image build targets (GraalVM)
- Heavy UI-based apps
- Reactive systems (non-blocking IO)

---

How to start the dropwizard application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/sample-app-jdbi-3.0.13-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`
4. To test the API, you can use a tool like `curl` or Postman. For example, to create a new person, you can use the following `curl` command:
```shell
curl -X POST http://localhost:8080/persons \
     -H "Content-Type: application/json" \
     -d '{"id":1,"name":"John Doe","email":"john@example.com"}'
     
curl http://localhost:8080/persons/1

curl http://localhost:8080/persons
```
Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

