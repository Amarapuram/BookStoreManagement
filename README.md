# Case Study: Bookstore Management System

## Overview

Built a Bookstore Management System using a microservices architecture, with each service responsible for specific functionality. The services communicate with each other via REST APIs, and data is managed using Spring Data JPA. The services are registered with a Eureka server and communicate using service names and Open Feign.

## Services

- **Book Service:** Manages book details such as title, author, price, and stock.
- **Order Service:** Manages customer orders and communicates with the Book Service to check stock availability before placing an order.
- **Customer Service:** Manages customer information.
- **Discovery Service:** A Eureka-based service that allows service registration and discovery.

## Goals Achieved

- **Spring REST API:** Implemented RESTful endpoints for managing books, customers, and orders.
- **Spring Data JPA:** Used Spring Data JPA to persist and retrieve data.
- **OpenFeign:** Implemented OpenFeign for inter-service communication between the Order Service and Book Service.
- **Eureka Service Discovery:** Enabled dynamic service registration and discovery using Eureka.

## Detailed Implementation

### Book Service

**Responsibilities:**
- Managed book data with CRUD operations.
- Maintained stock levels.
- Exposed REST endpoints to manage books.

**Entities:**
- `Book`: Represents a book with fields like `id`, `title`, `author`, `price`, and `stock`.

**REST Endpoints:**
- GET `/books`: List all books.
- GET `/books/{id}`: Get details of a specific book.
- POST `/books`: Add a new book.
- PUT `/books/{id}`: Update book details.
- DELETE `/books/{id}`: Remove a book.

### Order Service

**Responsibilities:**
- Managed customer orders.
- Checked book availability with the Book Service before placing an order using OpenFeign.
- Exposed REST endpoints to manage orders.

**Entities:**
- `Order`: Represents an order with fields like `id`, `customerId`, `bookId`, `quantity`, and `status`.

**REST Endpoints:**
- GET `/orders`: List all orders.
- GET `/orders/{id}`: Get details of a specific order.
- POST `/orders`: Place a new order (with stock check).
- PUT `/orders/{id}`: Update order details.
- DELETE `/orders/{id}`: Cancel an order.

**Feign Client:**
- Implemented a Feign Client in the Order Service to communicate with the Book Service to check stock availability.

### Customer Service

**Responsibilities:**
- Managed customer data and exposed REST endpoints to manage customers.

**Entities:**
- `Customer`: Represents a customer with fields like `id`, `name`, `email`, and `phoneNumber`.

**REST Endpoints:**
- GET `/customers`: List all customers.
- GET `/customers/{id}`: Get details of a specific customer.
- POST `/customers`: Add a new customer.
- PUT `/customers/{id}`: Update customer details.
- DELETE `/customers/{id}`: Remove a customer.

### Discovery Service

**Responsibilities:**
- Used Eureka Server to enable service registration and discovery.
- Ensured that the `Book`, `Order`, and `Customer` Services register with Eureka and can discover each other.

### Validations Implemented

**Entity: `Book`**
- **`title`:**
  - Not null/empty: Ensured the title is provided.
  - Length constraint: Limited the title length (1-255 characters).
- **`author`:**
  - Not null/empty: Ensured the author's name is provided.
  - Length constraint: Limited the author's name length (1-255 characters).
- **`price`:**
  - Not null: Ensured the price is provided.
  - Positive value: Ensured the price is greater than 0.
  - Precision constraint: Limited the number of decimal places (2 decimal places).
- **`stock`:**
  - Not null: Ensured the stock is provided.
  - Non-negative: Ensured the stock is 0 or more.

**Entity: `Order`**
- **`bookId`:**
  - Not null: Ensured that a book ID is provided.
  - Exists: Checked that the book ID exists in the Book Service before placing an order (handled via OpenFeign).
- **`quantity`:**
  - Not null: Ensured that the quantity is provided.
  - Positive value: Ensured the quantity is greater than 0.
  - Stock availability: Ensured that the requested quantity does not exceed the available stock in the Book Service.
- **`status`:**
  - Not null: Ensured that the order status is provided.
  - Valid status: Ensured the status is within a predefined set of values ("PENDING", "CONFIRMED", "CANCELLED").

**General Considerations:**
- **Global Exception Handling:** Implemented a global exception handler to manage validation errors and return meaningful error messages.
- **Input Validation:** Used `@Valid` annotations on REST controllers to automatically validate incoming data.
- **Custom Validation:** Implemented custom validators for complex business rules as needed.

### Implementation Steps Completed

1. **Set up the Eureka Discovery Service:**
   - Created a Spring Boot application with the Eureka Server dependency.
   - Enabled Eureka Server in the application.

2. **Developed the Book Service:**
   - Created a Spring Boot application for the Book Service.
   - Used Spring Data JPA to persist books.
   - Exposed REST endpoints for CRUD operations on books.
   - Registered the Book Service with Eureka.

3. **Developed the Order Service:**
   - Created a Spring Boot application for the Order Service.
   - Used Spring Data JPA to persist orders.
   - Implemented a Feign Client to communicate with the Book Service for stock checks.
   - Exposed REST endpoints for managing orders.
   - Registered the Order Service with Eureka.

4. **Developed the Customer Service:**
   - Created a Spring Boot application for the Customer Service.
   - Used Spring Data JPA to persist customers.
   - Exposed REST endpoints for managing customers.
   - Registered the Customer Service with Eureka.

5. **Tested the System:**
   - Used Postman to interact with the services.
   - Verified that the Order Service could successfully check stock with the Book Service before placing an order.
   - Ensured that all services were registered with Eureka and could discover each other.

### Expected Outcomes

- Gained mastery of Spring REST API development.
- Developed proficiency in Spring Data JPA for data persistence.
- Gained practical experience with OpenFeign for inter-service communication.
- Understood Eureka-based service discovery in a microservices architecture.

This case study provided hands-on experience with essential Spring Boot microservices components. I learned how to build and integrate multiple services to create a functional system, understanding the challenges and best practices of microservices development, including service communication, data management, and service discovery.
