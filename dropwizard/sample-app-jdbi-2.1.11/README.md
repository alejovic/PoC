# Proof of Concept - [Dropwizard]

# Dropwizard 2.1.11 with JDBI
---

🧠 **What is org.jdbi.v3?**
JDBI stands for Java Database Interface.

It’s a wrapper around JDBC (Java Database Connectivity) that makes it easier to work with databases in Java.

✅ It makes it easy to execute SQL from Java
✅ It avoids a lot of boilerplate (like manually writing JDBC connection, statement, resultset handling, etc.)
✅ It maps query results into Java objects (POJOs) automatically
✅ It fits perfectly with Dropwizard — that's why Dropwizard has dropwizard-jdbi3 module built-in.

---

# ⚡ Characteristics of **Dropwizard 2.1.11**

| Feature | Details |
|:--------|:--------|
| **Java version** | Java 8 minimum (Java 11 highly recommended) |
| **Core modules** | REST server (Jetty), Jackson (JSON), Jersey (JAX-RS), Hibernate (optional ORM), JDBI3 (SQL mapping), Metrics, Logging |
| **Architecture style** | Microservice / REST API-centric, simple startup |
| **Configuration** | YAML-driven (`config.yml`) |
| **Opinionated** | Batteries included — chooses libraries for you |
| **Jersey** | JAX-RS 2.1 (through Jersey 2.x) |
| **Metrics** | Built-in Metrics (Dropwizard Metrics library) |
| **Database** | Supports Hibernate ORM (via `dropwizard-hibernate`) and JDBI (via `dropwizard-jdbi3`) |
| **Health Checks** | Easy to implement service health monitoring |
| **Testing** | Built-in support with Dropwizard testing helpers |
| **Security** | Basic OAuth/JWT support via extensions |
| **Packaging** | Single **fat jar** runnable by `java -jar` |
| **Third-party Bundles** | e.g., Swagger integration (`dropwizard-swagger`) available |
| **Deployment** | Meant to be simple — no container required (Jetty embedded) |

---

# ⚡ Limitations / Drawbacks of **Dropwizard 2.1.11**

| Limitation | Details |
|:-----------|:--------|
| **Not modular** | All components bundled together — harder to customize compared to Spring Boot |
| **Tight integration to Jersey** | Only supports Jersey — no easy switch to other REST frameworks |
| **No built-in Dependency Injection framework** | No Spring-style DI (uses constructor injection manually) |
| **Startup** | Slower startup than Micronaut/Quarkus (but fine for most APIs) |
| **Front-end support** | Only server-side APIs — no native templating or frontend solutions (like Thymeleaf) |
| **Hibernate support** | Hibernate is optional but a bit dated — Hibernate Validator and Hibernate ORM are based on older Jakarta EE packages (`javax.*`) |
| **No AOT / Native compilation** | Unlike Micronaut or Quarkus, no GraalVM native image support without big tweaks |
| **Limited "magic"** | Very explicit — you write more configuration manually (good or bad depending on you!) |
| **Java 17+ needs upgrade** | If you want Java 17 officially, you should move to Dropwizard 3.x (2.x is not Java 17-certified) |

---

# 🧐 Realistic Use Cases

**When Dropwizard 2.1.11 is great:**
- REST APIs
- Microservices
- Lightweight backend applications
- Internal tools and admin backends
- You like **simple**, **explicit** frameworks (less "magic" than Spring Boot)

**When Dropwizard 2.1.11 might not be ideal:**
- Big, complex enterprise systems needing lots of modularity, dynamic beans
- Native image build targets (GraalVM)
- Heavy UI-based apps
- Reactive systems (non-blocking IO)

---

# 🚀 Summary

✅ Fast to build REST APIs  
✅ Great metrics/monitoring built-in  
✅ Simple packaging and deployment  
✅ Stable and mature  
⚠️ Not cutting-edge (no native builds, not modular)  
⚠️ Tied to Jersey, no alternate REST libraries  
⚠️ No fancy Dependency Injection

---

How to start the dropwizard application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/sample-app-jdbi-2.1.11-1.0-SNAPSHOT.jar server config.yml`
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

