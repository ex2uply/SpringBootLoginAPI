
# Spring Boot User Authentication and Registration with JWT

This project is a Spring Boot application demonstrating user authentication and registration features, with JWT (JSON Web Token) support for secure API access. The application is designed to work only with API clients like Postman, and CSRF protection is disabled to simplify API-based interaction.

## Features

- User authentication using Spring Security
- User registration with password encryption
- JWT-based authentication for secure API access
- Basic CRUD operations for student entities
- CSRF disabled for easier API interaction

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```
    git clone https://github.com/your-username/spring-boot-user-authentication-registration.git
    cd spring-boot-user-authentication-registration
    ```

2. Build the project using Maven:
    ```
    mvn clean install
    ```

3. Run the application:
    ```
    mvn spring-boot:run
    ```

### Configuration

The application uses an in-memory H2 database for development purposes. You can configure the database settings in the `application.properties` file.

## JWT Integration

### How JWT Works:

1. **Login**: Users authenticate with their username and password.
2. **Token Generation**: Upon successful authentication, a JWT token is generated and returned in the response.
3. **API Access**: For each subsequent API request, the client sends the JWT in the `Authorization` header (Bearer token).
4. **Token Validation**: The server validates the JWT to ensure the request is authenticated.

### Important Files for JWT

- **`JwtUtil.java`**: A utility class to generate, validate, and parse JWT tokens.
- **`JwtRequestFilter.java`**: A filter that intercepts API requests and validates the JWT token.
- **`SecurityConfig.java`**: Updated to allow JWT-based authentication and disable CSRF entirely (since the application interacts only via APIs).

### Example JWT Authentication Flow:

1. **Login**: Send a POST request to `/login` with the following JSON body:
   ```
   {
     "username": "your-username",
     "password": "your-password"
   }
   ```
   Upon successful login, you will receive a JWT token in the response.

2. **Accessing Protected Endpoints**: Include the JWT token in the `Authorization` header to access protected endpoints like `/students`.
   Example:
   ```
   curl -H "Authorization: Bearer <your-token>" -X GET http://localhost:8081/students
   ```

## Endpoints

- `/login` - Endpoint to authenticate users and generate JWT tokens
- `/register` - User registration endpoint
- `/students` - CRUD operations for students, requires JWT for access

## Example Usage

### Register a New User

Send a POST request to `/register` with the following JSON body:
```
{
  "userid": 1,
  "username": "newuser",
  "password": "password"
}
```

### Login and Receive JWT

Send a POST request to `/login`:
```
{
  "username": "your-username",
  "password": "your-password"
}
```
You will receive a JWT token in the response. Use this token for subsequent requests.

### Retrieve Students (JWT Required)

Send a GET request to `/students` with the JWT token in the `Authorization` header:
```
curl -H "Authorization: Bearer <your-token>" -X GET http://localhost:8081/students
```

### Add a New Student (JWT Required)

Send a POST request to `/students` with the JWT token and the following JSON body:
```
{
  "id": 4,
  "name": "New Student",
  "score": 85
}
```
