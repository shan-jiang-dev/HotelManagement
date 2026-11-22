# Hotel Management System

A RESTful backend application built with Java and Spring Boot for managing hotel records. Implements CRUD operations through REST APIs and persists data in a MySQL relational database using Spring Data JPA.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.2.0 | Backend application framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Data access and repository abstraction |
| Hibernate | ORM and entity persistence |
| MySQL | Relational database |
| Maven | Dependency management and build automation |
| Lombok | Boilerplate code reduction |
| Postman | REST API testing |
| Spring Security | Authentication and API security |

## Features

- **Create Hotels:** Add new hotel records to the database.
- **Retrieve Hotels:** Retrieve all hotel records or find a specific hotel by ID.
- **Update Hotels:** Modify existing hotel information.
- **Delete Hotels:** Remove hotel records by ID.
- **Database Persistence:** Store and manage hotel data using MySQL and Spring Data JPA.

## Security

- HTTP Basic Authentication using Spring Security.
- Username and password authentication.
- Authentication required to access protected REST endpoints.

## Authentication

Spring Security is used to protect the REST APIs through HTTP Basic Authentication.

The default Spring Security configuration generates a username and password when the application starts.

Default username: user

Password: Generated automatically and displayed in the application startup console.

## Getting Started

### Prerequisites

- Java JDK 21
- Maven
- MySQL

### 1. Clone the Repository

```bash
git clone https://github.com/shan-jiang-dev/HotelManagement.git
cd HotelManagement
```

### 2. Create the Database

```sql
CREATE DATABASE hotelmanagement;
```

### 3. Configure Database Connection

Update `src/main/resources/application.yml` with your MySQL credentials

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start at:

`http://localhost:8080`

## API Testing

The REST endpoints were tested using Postman.

| HTTP Method | Operation |
|---|---|
| GET | Retrieve all hotels |
| GET | Retrieve a hotel by ID |
| POST | Create a new hotel |
| PUT | Update an existing hotel |
| DELETE | Delete a hotel |


**Author:** [Shan Jiang](https://github.com/shan-jiang-dev)

