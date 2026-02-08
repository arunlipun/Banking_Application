<h1 align="center">🏦 Banking Application - Spring Boot REST API</h1>

<p align="center">
  <b>A backend banking system built using Spring Boot & MySQL</b><br/>
  RESTful APIs | Clean Architecture | DTO Pattern
</p>

<hr/>

## 📌 Project Overview
This **Banking Application** is a backend REST API developed using **Spring Boot**.  
It allows users to create bank accounts, fetch account details, deposit money, and delete accounts.

The project follows **industry-standard layered architecture** using:
- Controller
- Service
- Repository
- DTO
- Mapper

---

## 🚀 Features
- Create Bank Account
- Get All Accounts
- Get Account By ID
- Deposit Money
- Delete Account
- DTO based response handling
- Clean REST API design
- MySQL database integration

---

## 🛠 Tech Stack
| Technology | Usage |
|----------|------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | ORM |
| Hibernate | Database Mapping |
| MySQL | Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |
| Postman | API Testing |

---

## 🧱 Project Architecture
Controller → Service → Repository → Database

### Layer Explanation
- **Controller**  
  Handles HTTP requests and responses using `ResponseEntity`

- **Service**  
  Contains business logic and coordinates between layers

- **Repository**  
  Handles database operations using JPA

- **DTO (Data Transfer Object)**  
  Transfers safe data between layers

- **Mapper**  
  Converts Entity ↔ DTO

---

## 📂 Project Structure
src/main/java
└── com.bank.BankingApplication
    ├── controller
    │   └── AccountController.java
    ├── service
    │   ├── AccountService.java
    │   └── impl
    │       └── AccountServiceImpl.java
    ├── repository
    │   └── AccountRepository.java
    ├── entity
    │   └── Account.java
    ├── dto
    │   └── AccountDto.java
    ├── mapper
    │   └── AccountMapper.java
    └── BankingApplication.java

---

## 🌐 API Endpoints
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/accounts` | Create account |
| GET | `/api/accounts` | Get all accounts |
| GET | `/api/accounts/{id}` | Get account by ID |
| PUT | `/api/accounts/{id}/deposit` | Deposit money |
| DELETE | `/api/accounts/{id}` | Delete account |

---

## 🔄 Application Workflow
1. Client sends request (Postman / Frontend)
2. Controller receives request
3. Request mapped to DTO
4. Service applies business logic
5. Mapper converts DTO → Entity
6. Repository interacts with database
7. Entity converted back to DTO
8. Response returned using `ResponseEntity`

---

## 📚 What I Learned
- REST API development using Spring Boot
- Layered architecture implementation
- Entity vs DTO difference
- Mapper usage
- ResponseEntity handling
- CRUD operations with Spring Data JPA
- MySQL integration
- Clean code practices

---

## 🔮 Future Enhancements
- Withdraw API
- Global Exception Handling
- Input Validation
- JWT Authentication & Authorization
- Pagination & Sorting

---

## 👨‍💻 Author
**Arun Mohapatra**  
B.Tech CSE (AI & ML)  
Java | Spring Boot | Backend Developer

---

## ▶️ How to Run
1. Clone the repository  
   ```bash
   git clone <your-repository-url>
Configure MySQL in application.properties

Run the Spring Boot application

Test APIs using Postman



---


