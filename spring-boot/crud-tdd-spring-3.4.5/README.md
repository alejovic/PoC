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

### ✅ Step 3: Make Domain Tests Pass