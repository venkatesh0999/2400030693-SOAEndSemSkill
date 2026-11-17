# Tourist Record Management System with Token Validation

## About the Project
This project is a Spring Boot backend application developed to manage tourist records for a hotel check-in system.

It allows users to add, view, and update tourist details. Custom token validation is implemented to prevent unauthorized updates.
## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger UI
- Spring Tool Suite (STS)

## Key Features
- Create and retrieve tourist records.
- Update tourist destination and contact details.
- Validate custom request tokens.
- Reject unauthorized requests with HTTP 401.

## Token Validation
The update API requires the `X-REQUEST-TOKEN` header.

- Valid token: `HOTEL123` → 200 OK
- Invalid token: `WRONG123` → 401 Unauthorized
- Missing token → 401 Unauthorized

## Run the Project
1. Configure PostgreSQL in `application.properties`.
2. Create the `tourist_db` database.
3. Run `TouristManagementApplication.java`.
4. Open Swagger UI:

http://localhost:8080/swagger-ui/index.html


