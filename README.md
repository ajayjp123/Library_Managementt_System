[Watch the video here](https://drive.google.com/file/d/1LIiK1ZrnvRn_Uvk_MjAmAYzv9SprBclU/view?usp=drive_link)


# Library Management System

This project consists of three components:  
1. **Eureka Server**  
2. **Book Service Application**  
3. **Book Order Service Application**

---

### Prerequisites
- Java Development Kit (JDK)
- Maven
- Postman (for testing)
- IDE (e.g., IntelliJ IDEA, Eclipse)

# Instructions

1. Start the eureka application: Library_Management_System\eureka\src\main\java\com\example\eureka\EurekaApplication
2. Start the first microservice - book-service : Library_Management_System\book-service\src\main\java\com\example\product\service\BookServiceApplication
3. Start the second microservice - book-order-service: Library_Management_System\book-order-service\src\main\java\com\example\order\service\BookOrderServiceApplication
4. Test using postman as shown in video

## Project Flow and Communication

### Flow of the Project
1. **Eureka Server**:
   - The Eureka Server acts as the **service registry** for the microservices.
   - Both `book-service` and `book-order-service` register themselves with the Eureka Server, enabling them to discover each other dynamically.

2. **Book-Service**:
   - The first microservice is responsible for managing book-related operations such as retrieving book details.
   - It registers itself with the Eureka Server for service discovery.

3. **Book-Order-Service**:
   - The second microservice handles operations related to book orders.
   - It also registers itself with the Eureka Server and uses **FeignClient** to communicate with the `book-service`.

### Role of Eureka and FeignClient
- **Eureka**:
  - Provides service discovery, allowing the `book-service` and `book-order-service` to dynamically discover and communicate with each other without needing hardcoded service URLs.
  - Both services register themselves with Eureka and retrieve service instances via the Eureka registry.

- **FeignClient**:
  - Simplifies inter-service communication by abstracting REST API calls.
  - The `book-order-service` uses FeignClient to invoke methods from the `book-service` as if they were local method calls.

By combining Eureka and FeignClient, the system ensures scalability, flexibility, and ease of communication between microservices.
