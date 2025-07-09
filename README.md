# Spring Boot Demo: Bank Application API

## Overview
This project is a Spring Boot RESTful API for managing bank applications, banks, branches, and transaction histories. It uses an H2 in-memory database for development and testing, and is ready for integration with a frontend.

## Features
- **Bank & Branch Lookup**: Fetch all banks and branches for a specific bank.
- **Application Management**: CRUD operations for applications.
- **Transaction History Management**: CRUD operations for transaction histories.
- **Global API Prefix**: All endpoints are prefixed with `/api/v1`.
- **H2 Console**: Access the in-memory database at `/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`).

## Technologies
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Running the Application
1. Clone the repository.
2. In the project root, run:
   ```bash
   ./mvnw clean spring-boot:run
   ```
3. The API will be available at `http://localhost:8080/api/v1`.

### H2 Database Console
- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(leave blank)*

## API Endpoints

### Bank & Branch Lookup
- **GET** `/api/v1/banks` — List all banks
- **GET** `/api/v1/branches?bank_id={id}` — List all branches for a bank

### Application
- **GET** `/api/v1/applications` — List all applications
- **GET** `/api/v1/applications/{id}` — Get application by ID
- **POST** `/api/v1/applications` — Create application
- **PUT** `/api/v1/applications/{id}` — Update application
- **DELETE** `/api/v1/applications/{id}` — Delete application

#### Application JSON Example
```json
{
  "bankName": "Bank A",
  "branchName": "Branch A1",
  "accountName": "John Doe",
  "accountNumber": "1234567890",
  "status": "Draft",
  "createdAt": "2024-07-09T12:00:00",
  "updatedAt": "2024-07-09T12:00:00"
}
```

### Transaction History
- **GET** `/api/v1/transaction-histories` — List all transaction histories
- **GET** `/api/v1/transaction-histories/{id}` — Get transaction history by ID
- **POST** `/api/v1/transaction-histories` — Create transaction history
- **PUT** `/api/v1/transaction-histories/{id}` — Update transaction history
- **DELETE** `/api/v1/transaction-histories/{id}` — Delete transaction history

#### Transaction History JSON Example
```json
{
  "description": "Deposit",
  "transactionId": "TXN123456",
  "status": "Completed",
  "createdAt": "2024-07-09T12:00:00"
}
```

## Data Seeding
- On startup, the application seeds two banks ("Bank A", "Bank B") and three branches ("Branch A1", "Branch A2" for Bank A, "Branch B1" for Bank B).

## Integration Notes
- All endpoints return and accept JSON.
- Use the provided URLs and JSON structures for frontend integration.
- For date/time fields, use ISO 8601 format (e.g., `2024-07-09T12:00:00`).

## License
This project is for demonstration and educational purposes. 