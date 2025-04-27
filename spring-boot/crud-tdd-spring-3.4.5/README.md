# CRUD TDD Spring Boot 3.4.5
---

This project demonstrates a simple CRUD application using Spring Boot 3.4.5, H2 database, and Hibernate ORM. The application follows a Test-Driven Development (TDD) approach, ensuring that tests are written before the actual implementation.
## Technologies Used
- **Spring Boot**: A framework for building Java applications.
- **H2 Database**: An in-memory database for testing purposes.
- **Hibernate**: An ORM framework for mapping Java objects to database tables.
- **JUnit 5**: A testing framework for Java.
- **Mockito**: A mocking framework for unit tests.
- **Spring Data JPA**: A part of Spring that makes it easy to implement JPA-based repositories.
- **Spring Web**: For building web applications.
- **Spring Boot DevTools**: For development-time features like automatic restarts.
- **Lombok**: A library that helps to reduce boilerplate code in Java.

---

Use Case:
---
* A Product can be part of many Orders.
* An Order can contain multiple Products (many-to-many).

---

### ✅ Step 1: Project Setup
* Use Spring Initializr with:
* Spring Web
* Spring Data JPA
* H2 Database
* Lombok (optional but helpful)
* Spring Boot DevTools (optional)
* Spring Boot Test (comes by default)

### ✅ Step 2: Define Domain Tests (TDD First)
com/avg/demo/crud/model/OrderTest.java
com/avg/demo/crud/model/ProductTest.java

### ✅ Step 3: Make Domain Tests Pass
com/avg/demo/crud/model/Order.java
com/avg/demo/crud/model/Product.java

### ✅ Step 4: Write Repository Tests
- @DataJpaTest: annotation is used to test JPA repositories in Spring Boot applications. It’s a specialized test annotation that provides a minimal Spring context for testing the persistence layer. This annotation can be used in conjunction with other testing annotations like @RunWith and @SpringBootTest.

1. com/avg/demo/crud/repository/ProductRepositoryTest.java
2. com/avg/demo/crud/repository/OrderRepositoryTest.java

### ✅ Step 5: Repositories
```java
// It's because ORDER is a reserved SQL keyword (in ORDER BY, etc).
@Table(name = "orders")
public class Order { . . . }
```
1. com/avg/demo/crud/repository/ProductRepository.java
2. com/avg/demo/crud/repository/OrderRepository.java

### ✅ Step 6: Write Service Tests
1. com/avg/demo/crud/service/ProductServiceTest.java
2. com/avg/demo/crud/service/OrderServiceTest.java

### ✅ Step 7: Implement Services
```java
@ExtendWith(MockitoExtension.class) 
// It tells JUnit 5 (the test runner) to use the MockitoExtension, which enables Mockito's features like automatic mock initialization.

@InjectMocks 
// It creates an instance of the class you want to test, and injects mocks (created by @Mock) into it automatically.
```
1. com/avg/demo/crud/service/ProductService.java
2. com/avg/demo/crud/service/OrderService.java


### ✅ Step 8: Create Controller Tests (SpringBootTest or MockMvc)

| Feature | @SpringBootTest | MockMvc (with @WebMvcTest) |
|:---|:---|:---|
| **Scope** | Loads the **entire Spring Boot application context** | Loads **only the web (MVC) layer**, like controllers |
| **Speed** | **Slower** (starts everything: database, services, security, etc.) | **Faster** (only web stuff is started) |
| **When to use** | For **full integration tests** (e.g., check real DB, services, security) | For **unit tests or slice tests** focused on **controllers** |
| **Mocking needed?** | Usually **less mocking** — real beans are available | **Must mock** service layers and dependencies manually |
| **Testing real behavior** | Yes — tests real interactions between all layers | No — tests the controller in **isolation** |
| **Example usage** | Testing a full API workflow (controller → service → repository → DB) | Testing a controller endpoint returns correct HTTP status, body, etc. |

```java
@WebMvcTest
// It tells Spring Boot to start only the web layer — specifically the Spring MVC components like controllers, filters, etc
. . .
@Autowired
MockMvc mockMvc;
. . .
mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.orderNo").value("ABC-123"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.products[0].name").value("ProductTestName"));

```
1. com/avg/demo/crud/controller/ProductControllerTest.java
2. com/avg/demo/crud/controller/OrderControllerTest.java

### ✅ Step 9: Controller Implementations

1. com/avg/demo/crud/controller/ProductController.java
2. com/avg/demo/crud/controller/OrderController.java

### Step 10: Finish Service Implementations and Tests
Repeat TDD and add more operations.

### Step 11: Final Test

#### Product API
```shell
curl http://localhost:8080/v1/products/1

curl -X POST http://localhost:8080/v1/products \
  -H "Content-Type: application/json" \
  -d '{"name":"New Laptop", "price": 5}'
  
curl -X PUT http://localhost:8080/v1/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"New Laptop", "price": 99}'  
```
#### Order API
```shell
curl http://localhost:8080/v1/orders/1

curl -X POST http://localhost:8080/v1/orders \
  -H "Content-Type: application/json" \
  -d '{
  "orderNo" : "ABC-123",
  "productIds" : [ 1 ]
}'
  
curl -X PUT http://localhost:8080/v1/orders/1 \
  -H "Content-Type: application/json" \
  -d '{
  "orderNo" : "XYZ-999",
  "productIds" : [ 1, 2 ]
}'
```
### Step 12: DTOs (Data Transfer Objects)

DTOs are simple Java objects that transfer data between layers in an application, such as between a DAO (Data Access Object) and a controller or service. They typically contain no business logic and only fields with getters and setters.

Why Use DTOs?

* Separation of Concerns: DTOs separate the internal data structure of the database or entity from the representation used in APIs or UI layers.
* Security: Prevents exposing sensitive fields from entities.
* Performance: Customizing the data returned (e.g., only required fields) reduces the payload size.
* Flexibility: Facilitates API versioning and different representations for the same entity.

### Step 13: Projections

✅ What is a Projection?

In Spring Data JPA, a projection lets you select only parts of an entity. You can use:

* Interfaces (closed projections)
* DTOs/Records (open projections with JPQL or native queries)

```shell
curl http://localhost:8080/v1/orders/summary
```

Why Use Projections?

* Performance: Avoids fetching unnecessary fields, reducing memory usage and improving query performance.
* Convenience: Can directly fetch data in the required format, bypassing additional mapping logic.

---
| Aspect        | DTO (Data Transfer Object)                                     | Projections                                         | Mappers                                           |
|---------------|-----------------------------------------------------------------|-----------------------------------------------------|---------------------------------------------------|
| **Definition** | An object that carries data between processes                  | A subset of fields selected from a database query   | A mechanism to transform data between objects     |
| **Pros**       | - Encapsulates data<br>- Decouples layers<br>- Validation friendly | - Reduces amount of data transferred<br>- Faster queries<br>- Lightweight objects | - Centralized transformation logic<br>- Reusable<br>- Helps maintain separation of concerns |
| **Cons**       | - Needs manual maintenance<br>- Risk of duplication<br>- Extra code | - Limited logic<br>- May tightly couple to DB schema | - Extra layer to maintain<br>- Potential performance cost if complex |
| **Use Case**   | - API responses<br>- Transfer between services<br>- Domain isolation | - Read-only views<br>- Fetching only necessary fields<br>- Reporting | - Mapping entities to DTOs and vice versa<br>- Transformation during persistence or retrieval |

### Step 14: Cache

Spring Boot already supports it internally, but optionally you can add dependencies if you want fancy cache backends like Ehcache or Caffeine.

For basic memory caching, no extra dependency is needed.

#### Steps
1. @EnableCaching | In main app class
2. @Cacheable("cacheName") | On service read methods
3. @CacheEvict(value = "cacheName", allEntries = true) | On service write methods

**Redis:** 
* Add Redis starter `spring-boot-starter-data-redis`
* Add Docker starter `spring-boot-docker-compose`
* Use JSON Serializer `RedisConfig` vs `implements Serializable`
```properties
# Redis configuration
spring.cache.type=redis

spring.data.redis.host=localhost
spring.data.redis.port=6379
```