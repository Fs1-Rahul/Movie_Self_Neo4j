# Movie_Self_Neo4j
Here I Created a Database with entity Movie with Has 5 Properties and applied Spring boot techniques to get the working
# Features
Graph Database Integration: Uses Spring Data Neo4j to manage movie nodes.
Role-Based Security: Implements Spring Security to distinguish between USER (read-only) and ADMIN (read/write) roles.
Three-Tier Architecture: Organizes code into Controller, Service, and Repository layers for better maintainability.
Custom Exception Handling: Uses @ControllerAdvice to handle validation errors and resource-not-found scenarios gracefully.
Data Validation: Utilizes Hibernate Validator to ensure data integrity before persistence.
## Tech Stack
Java: JDK 17+ (Eclipse IDE 2026-03)
Framework: Spring Boot 3.x
Database: Neo4j (Graph Database)
Security: Spring Security
Testing: Postman
