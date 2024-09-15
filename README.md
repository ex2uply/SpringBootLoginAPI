# User Authentication and Registration System with Spring Boot

This project is a robust, full-featured Spring Boot application that demonstrates a secure and scalable user authentication and registration system. It includes functionalities for user registration, password encryption, form-based login, and basic CRUD operations for managing student entities.

## Key Features

- **User Authentication**: Secured login functionality with Spring Security.
- **User Registration**: Allows users to register securely with password encryption (BCrypt).
- **Custom Login Page**: A user-friendly, custom login page for enhanced UX.
- **CRUD Operations**: Basic Create, Read, Update, and Delete (CRUD) operations for student entities.
- **CSRF Protection**: Integrated Cross-Site Request Forgery protection to enhance security.

## Technology Stack

- **Java 21+**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **PostgresSQL**
- **Maven**
- **Lombok**
- **Bcrypt**

## Getting Started

### Prerequisites

Ensure the following software is installed on your machine:

- **Java 17** or higher
- **Maven 3.6.0** or higher

### Installation Steps

1. Clone the repository to your local machine:
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

The application is pre-configured to use an in-memory Postgres database for development. To modify database settings, update the `application.properties` file located in `src/main/resources`.

## Project Structure Overview

- **`SecurityConfig.java`**: Configures Spring Security, including custom form-based login, session management, and HTTP Basic authentication.
- **`MyUserDetailsService.java`**: Implements `UserDetailsService` to load user-specific data for authentication.
- **`UserPrincipal.java`**: Implements `UserDetails`, representing the currently authenticated user.
- **`RegisterService.java`**: Handles the user registration process, including password encryption using `BCryptPasswordEncoder`.
- **`UserController.java`**: Manages user-related operations like registration.
- **`StudentController.java`**: Provides CRUD functionality for student entities, including CSRF token handling for secure form submissions.

## API Endpoints

- **`/login`**: Custom login page for user authentication.
- **`/register`**: Endpoint for user registration.
- **`/students`**: CRUD operations for managing student entities.
- **`/csrf-token`**: Endpoint to retrieve CSRF tokens for secure requests.

## Example Usage

### Register a New User

To register a new user, send a POST request to `/register` with the following JSON body:
```json
{
  "userid": 1,
  "username": "newuser",
  "password": "password"
}
```

### Login

Access the custom login page at `/login` and enter your credentials to authenticate.

### Student Operations

- **Retrieve All Students**: Send a GET request to `/students` to fetch all student records.
- **Add a New Student**: To add a student, send a POST request to `/students` with a JSON body like:
  ```json
  {
    "id": 4,
    "name": "New Student",
    "score": 85
  }
  ```

## Security Considerations

- **Password Encryption**: All passwords are encrypted using `BCryptPasswordEncoder` for enhanced security.
- **CSRF Protection**: The application includes CSRF tokens to mitigate Cross-Site Request Forgery attacks.

## License

This project is licensed under the MIT License.

