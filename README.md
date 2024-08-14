# Library Automation System
## Project Overview
This project is a Library Automation System developed as part of the Java 101 + Spring Bootcamp provided by TechCareer. It utilizes the Spring Framework and Java to manage basic library operations. The project includes functionalities for managing books, members, loan transactions, and reservations.
## Features
* Member Management: Adding, updating, deleting, and listing members.
* Book Management: Adding, updating, deleting, and listing books.
* Loan Transactions: Lending books to members and handling returns.
* Reservation Management: Making and managing reservations for books.
## Technologies
* Java: The primary programming language used in the project.
* Spring Boot: Framework used for building the application.
* Lombok: Automatically generates getter and setter methods.
* Spring Data JPA: Used for database operations.
* MySQL Database: Lightweight database used during development.
## Setup
### Requirements
* Java 21 or higher
* Maven
* IDE (Eclipse, IntelliJ IDEA, etc.)
### Steps
1. Clone the Repository:
   ` git clone https://github.com/username/library-automation-system.git `
2. Navigate to the Project Directory:
   ` cd library-automation-system `
3. Install Maven Dependencies:
   ` mvn clean install `
4. Run the Application:
   ` mvn spring-boot:run `
The application will be available at http://localhost:8080 by default.

## API Usage Guide

### Member Management

- **Add Member:**

  **Endpoint:** `POST /members/create`

  **Request Body:**

  ```json
  {
      "name": "John",
      "lastName": "Doe",
      "address": "123 Main St",
      "phoneNumber": "123-456-7890",
      "email": "john.doe@example.com"
  }
  ```
* Update Member:
Endpoint ` PUT /members/update `
Request Body:
```json
{
    "id": 1,
    "name": "John",
    "lastName": "Smith",
    "address": "123 Main St",
    "phoneNumber": "123-456-7890",
    "email": "john.smith@example.com"
}
```
* Delete Member
Endpoint: ` DELETE /members/{id} `
* Get All Members
Endpoint: ` GET /members/getAll `

### Book Resevation, Loan and Staff Management processes are explained in detail in the presentation. 

## License
This project is licensed under the MIT License.
## Contact
For any questions, please contact ozlemnduman34@hotmail.com or https://www.linkedin.com/in/ozlemnurduman.
