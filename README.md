# student-microservices-project-Spring-Security-Eureka-JWT-
 Student Management Microservices Project (Spring Boot + Eureka + JWT + Spring Security)

This is a beginner-friendly **Microservices Project** built using **Spring Boot** and **Spring Cloud Netflix Eureka**.

It demonstrates:
- Microservices Architecture
- Service Registration & Discovery (Eureka Server)
- Authentication using JWT Token
- Password Encryption using BCrypt
- Securing APIs using Spring Security + JWT Filter
- CRUD Operations on Student Service

---

## 🚀 Technologies Used
- Java 17
- Spring Boot 3.2.6
- Spring Security
- Spring Data JPA
- Spring Cloud Netflix Eureka
- JWT (jjwt library)
- MySQL Database
- Postman (API Testing)

---

## 📌 Microservices in this Project

### 1️⃣ Eureka Server
- Runs on: **8761**
- Used as a **Service Registry**
- Dashboard URL:  
  `http://localhost:8761`

### 2️⃣ Auth Service
- Runs on: **8081**
- Features:
  - Register User
  - Login User
  - Generate JWT Token
  - Encrypt password using BCrypt
- Database: `micro_auth`

### 3️⃣ Student Service
- Runs on: **8082**
- Features:
  - Student CRUD APIs
  - Protected endpoints using JWT Token
- Database: `micro_student`

---

## 🗂 Project Folder Structure

student-microservices-project/
├── eureka-server/
├── auth-service/
├── student-service/


---

## 🛠 MySQL Setup
Create databases:

```sql
CREATE DATABASE micro_auth;
CREATE DATABASE micro_student;

Update MySQL username and password in:

auth-service/src/main/resources/application.properties
student-service/src/main/resources/application.properties
▶️ How to Run the Project
Step 1: Run Eureka Server

Start the eureka-server project.

Check dashboard:
http://localhost:8761

Step 2: Run Auth Service

Start the auth-service project.

Step 3: Run Student Service

Start the student-service project.

Step 4: Check Eureka Dashboard

Open:
http://localhost:8761

You should see both services registered:

AUTH-SERVICE
STUDENT-SERVICE
🧪 Testing APIs Using Postman
✅ 1. Register User

POST

http://localhost:8081/auth/register

Body (JSON):

{
  "username": "atharva",
  "password": "1234"
}

Response:

Registered Successfully!
✅ 2. Login User (Get Token)

POST

http://localhost:8081/auth/login

Body (JSON):

{
  "username": "atharva",
  "password": "1234"
}

Response:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

Copy the token.

✅ 3. Get All Students (Protected API)

GET

http://localhost:8082/students

Headers:

Authorization : Bearer <your_token>

Example:

Authorization : Bearer eyJhbGciOiJIUzI1NiJ9...

Response:

[]
✅ 4. Add Student (Protected API)

POST

http://localhost:8082/students

Headers:

Authorization : Bearer <your_token>
Content-Type : application/json

Body:

{
  "name": "Rahul",
  "course": "Java",
  "age": 21
}
✅ 5. Delete Student (Protected API)

DELETE

http://localhost:8082/students/1

Headers:

Authorization : Bearer <your_token>

Response:

Deleted Successfully
🔐 Security Features Implemented
BCrypt password hashing (password is never stored in plain text)
JWT Authentication (token-based authentication)
Spring Security for securing APIs
JWT Filter for validating tokens in Student Service
📌 Key Learning Outcomes
Understanding microservices architecture
Service registration and discovery using Eureka
JWT token generation and validation
Implementing Spring Security with filters
Securing REST APIs
👨‍💻 Author

Atharva Joshi
GitHub: https://github.com/AtharvaBuilds
