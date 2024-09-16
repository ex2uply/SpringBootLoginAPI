# Spring Boot User Authentication and Registration with JWT

This project is a Spring Boot application that demonstrates user authentication and registration, using JWT (JSON Web Token) to secure API access. It's designed for API clients like Postman, with CSRF protection disabled to simplify API interaction.

## Key Features

- User authentication with Spring Security
- User registration with encrypted passwords
- JWT-based authentication for secure API requests
- Basic CRUD operations for managing student data
- CSRF protection disabled for easier API usage

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- Maven

## Getting Started

### Prerequisites

- Java 17 or newer
- Maven 3.6.0 or later

### Installation Steps

1. Clone the repository:
    ```
    git clone https://github.com/your-username/spring-boot-user-authentication-registration.git
    cd spring-boot-user-authentication-registration
    ```

2. Build the project with Maven:
    ```
    mvn clean install
    ```

3. Run the application:
    ```
    mvn spring-boot:run
    ```

### Configuration

The app uses an in-memory H2 database for development. You can update the database settings in the `application.properties` file as needed.

## JWT Overview

### How JWT Works:

1. **Login**: Users provide a username and password.
2. **Token Creation**: Upon successful login, a JWT token is generated and sent back to the user.
3. **API Access**: The client includes the JWT in the `Authorization` header (as a Bearer token) when making requests.
4. **Token Verification**: The server checks the JWT on each request to verify the user's identity.

### Key JWT Files

- **`JwtUtil.java`**: Manages generating, validating, and parsing JWT tokens.
- **`JwtRequestFilter.java`**: Intercepts incoming requests to validate JWT tokens.
- **`SecurityConfig.java`**: Configures security settings, enabling JWT authentication and disabling CSRF protection.

### JWT Authentication Flow Example:

1. **Login**: Send a POST request to `/login` with the following JSON body:
   ```json
   {
     "username": "your-username",
     "password": "your-password"
   }
   ```
   After successful login, the server returns a JWT token.

2. **Accessing Protected Endpoints**: To access secured endpoints like `/students`, send the JWT token in the `Authorization` header.
   Example:
   ```
   curl -H "Authorization: Bearer <your-token>" -X GET http://localhost:8081/students
   ```

## Available API Endpoints

- `/login`: Authenticates users and returns a JWT token.
- `/register`: Registers new users with encrypted passwords.
- `/students`: Provides CRUD operations for student data, accessible only with a valid JWT.

## Example API Usage

### Register a New User

Send a POST request to `/register` with this JSON body:
```json
{
  "userid": 1,
  "username": "newuser",
  "password": "password"
}
```

### Login and Get JWT

Send a POST request to `/login`:
```json
{
  "username": "your-username",
  "password": "your-password"
}
```
The response will contain a JWT token. Use this token for subsequent API requests.

### Retrieve Students (Requires JWT)

Send a GET request to `/students` with the JWT token in the `Authorization` header:
```
curl -H "Authorization: Bearer <your-token>" -X GET http://localhost:8081/students
```

### Add a New Student (Requires JWT)

Send a POST request to `/students` with your JWT token and this JSON body:
```json
{
  "id": 4,
  "name": "New Student",
  "score": 85
}
```
