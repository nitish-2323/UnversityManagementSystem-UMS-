University Management System (UMS)

A Java Spring Boot Microservices-based University Management System
designed to manage core university entities such as departments, roles,
students, and teachers.

The project is being developed incrementally, with each service
organized as an independent Spring Boot application and maintained in a
single Git repository.

🚀 Project Status

Completed

✅ Department Service

✅ Eureka Server / Service Discovery

✅ Role Service

✅ Student Service

✅ Teacher Service

✅ Inter-service communication for Student and Teacher services

✅ Resilience4j circuit-breaker/fallback integration in the service
communication layer

In Progress

🔄 Admin Service

🔄 API Gateway

⏳ Spring Security

⏳ JWT Authentication & Authorization

⏳ Frontend with React

Current milestone: The backend has been developed through the
Teacher Service. The next stage is to complete the remaining
infrastructure/security work and then build the React frontend.

🏗️ Architecture

                         ┌─────────────────────┐
                         │     React Frontend  │
                         │      (Planned)      │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │    API Gateway      │
                         │      (In Progress)  │
                         └──────────┬──────────┘
                                    │
                    ┌───────────────┼────────────────┐
                    │               │                │
                    ▼               ▼                ▼
             ┌────────────┐  ┌────────────┐  ┌────────────┐
             │  Student   │  │  Teacher   │  │   Admin    │
             │  Service   │  │  Service   │  │  Service   │
             └─────┬──────┘  └─────┬──────┘  └────────────┘
                   │               │
                   └───────┬───────┘
                           │
                    ┌──────▼──────┐
                    │ Department  │
                    │   Service   │
                    └─────────────┘

                    ┌─────────────┐
                    │ Role Service│
                    └─────────────┘

                    ┌─────────────┐
                    │Eureka Server│
                    │  Discovery  │
                    └─────────────┘

📁 Project Structure

UnversityManagementSystem-UMS-
│
├── DepartmentService/
│   ├── src/main/java/
│   │   └── com/UMS/DepartmentService/
│   │       ├── Controller/
│   │       ├── DTO/
│   │       ├── Entity/
│   │       ├── Execption/
│   │       ├── Repository/
│   │       └── Service/
│   └── src/main/resources/
│
├── EurekaServer/
│   ├── src/main/java/
│   │   └── com/UMS/EurekaServer/
│   └── src/main/resources/
│
├── RoleService/
│   ├── src/main/java/
│   │   └── com/UMS/RoleService/
│   │       ├── Controller/
│   │       ├── DTO/
│   │       ├── Entity/
│   │       ├── Execption/
│   │       ├── Repository/
│   │       └── Service/
│   └── src/main/resources/
│
├── StudentService/
│   ├── src/main/java/
│   │   └── com/UMS/StudentService/
│   │       ├── Client/
│   │       ├── Configuration/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── execption/
│   │       ├── repository/
│   │       └── service/
│   └── src/main/resources/
│
├── TeacherService/
│   ├── src/main/java/
│   │   └── com/UMS/TeacherService/
│   │       ├── client/
│   │       ├── configure/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── execption/
│   │       ├── mapper/
│   │       ├── repository/
│   │       └── service/
│   └── src/main/resources/
│
├── AdminService/          # In progress
├── ApiGateway/            # In progress
│
├── pom.xml
├── .gitignore
└── README.md

🧩 Services

Service                 Responsibility          Status

Department Service      Manage university       ✅ Completed
departments

Role Service            Manage application/user ✅ Completed
roles

Student Service         Manage student          ✅ Completed
information and
operations

Teacher Service         Manage teacher          ✅ Completed
information and
operations

Eureka Server           Service discovery and   ✅ Completed
registration

Admin Service           Administrative          🔄 In Progress
operations and
management

👨‍🎓 Student Service

The Student Service provides APIs for managing student information.

Main layers

Controller

DTO

Entity

Repository

Service

Client

Exception Handling

Configuration

The service also communicates with other services to retrieve related
Department and Role information.

👨‍🏫 Teacher Service

The Teacher Service is the latest completed business service in the
project.

Main layers

Controller

DTO

Entity

Repository

Service

Mapper

Exception Handling

Client

Configuration

Teacher data includes

Teacher ID

First Name

Last Name

Username

Email

Mobile

Date of Birth

Gender

Address

Qualification

Specialization

Joining Date

Department ID

Role ID

Status

Created At

Updated At

The Teacher Service also integrates with the Department Service and
Role Service to retrieve related information.

🔗 Microservice Communication

The project uses service-to-service communication to avoid keeping all
university data inside one application.

For example:

TeacherService
      │
      ├──────► DepartmentService
      │
      └──────► RoleService

The project also contains client/configuration components for handling
these service calls.

🔎 Service Discovery

The project uses Eureka Server for service registration and
discovery.

              ┌─────────────────┐
              │  Eureka Server  │
              └────────┬────────┘
                       │
       ┌───────────────┼────────────────┐
       │               │                │
       ▼               ▼                ▼
 StudentService   TeacherService   RoleService
       │
       ▼
 DepartmentService

This allows services to discover each other using service names instead
of relying entirely on fixed host addresses.

🛡️ Resilience

Resilience4j is being used for fault-tolerant communication between
services.

Fallback handling is included so that a dependent service being
unavailable does not necessarily cause the entire request to fail
without a controlled response.

🗄️ Database

Each business service is designed as an independent Spring Boot
application with its own persistence layer.

The project uses:

Spring Data JPA

Hibernate

MySQL

🛠️ Technology Stack

Backend

Java

Spring Boot

Spring MVC

Spring Data JPA

Hibernate

REST APIs

Maven

Microservices

Spring Cloud

Netflix Eureka

API Gateway

Resilience4j

Database

MySQL

Development & Testing

IntelliJ IDEA

Postman

Git

GitHub

Planned Frontend

React.js

HTML

CSS

JavaScript

Planned Security

Spring Security

JWT

Authentication

Authorization

📌 Development Roadmap

[Completed]
Department Service
        ↓
Eureka Server
        ↓
Role Service
        ↓
Student Service
        ↓
Teacher Service

[Next]
Admin Service
        ↓
API Gateway
        ↓
Complete Microservice Integration
        ↓
Spring Security
        ↓
JWT Authentication & Authorization
        ↓
React Frontend
        ↓
Frontend ↔ API Gateway Integration

📈 Git Development History

The project is developed using incremental feature-based commits.

Examples:

feat: initialize student service
feat: add student entity and repository
feat: add student request and response DTOs
feat: implement student service business logic
feat: add student APIs and service integration

feat: initialize teacher service
feat: add teacher entity and repository
feat: add teacher request and response DTOs
feat: add department and role response DTOs
feat: implement teacher service business logic
feat: add teacher APIs and exception handling
feat: add teacher service integration

This commit structure documents the development progression of each
service.

▶️ Running the Project

Each microservice is an independent Spring Boot application.

A typical startup sequence is:

1. Eureka Server
2. Department Service
3. Role Service
4. Student Service
5. Teacher Service
6. Admin Service
7. API Gateway
8. React Frontend

The exact startup order and ports depend on the application.yaml
configuration of each service.

🧪 API Testing

REST APIs are tested using Postman.

Testing currently focuses on:

CRUD operations

Request/response validation

Exception handling

Service-to-service communication

Dependent-service fallback behavior

🎯 Project Goal

The goal of this project is to build a realistic University Management
System using Java Spring Boot and Microservices Architecture, while
applying industry-relevant backend concepts such as:

Layered architecture

RESTful APIs

DTO pattern

Repository pattern

Service layer

Exception handling

Microservice communication

Service discovery

Circuit breaker/fallback

API Gateway

Authentication & authorization

Frontend integration

👤 Author

Nitish Thakur

B.Tech Computer Science Engineering

📜 License

This project is created for learning, development, and portfolio
purposes.
