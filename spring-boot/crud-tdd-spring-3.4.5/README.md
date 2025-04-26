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
