# 📝 Simple Feedback API

A Spring Boot 3.x RESTful service to collect user feedback. Validates input fields and persists feedback in a PostgreSQL database. Unit-tested using JUnit and Mockito.

---

## ✅ Features

- Accepts feedback (`name`, `email`, `message`)
- Input validation using annotations like `@NotBlank`, `@Email`, `@Size`
- Data persistence using Spring Data JPA with PostgreSQL
- REST endpoints tested using Insomnia/cURL
- Unit testing for service logic

---
## 🚀 How to Run the Project

1. ✅ Ensure PostgreSQL is running.
2. ✅ Create a database (e.g. `feedback_db`).
3. ✅ Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/feedback_db
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

✅ Run the project:

bash
mvn spring-boot:run
The application will start at:
http://localhost:8080

🟢 Submit Feedback
POST /feedback
Content-Type: application/json

✅ Sample Request (Valid)
bash

curl -X POST http://localhost:8080/feedback \
  -H "Content-Type: application/json" \
  -d '{
    "name": "XYZ",
    "email": "xyz@example.com",
    "message": "Great project!"
}'

❌ Sample Request (Invalid – missing email)
bash

curl -X POST http://localhost:8080/feedback \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mrunali",
    "message": "Missing email"
}'

Expected Response:

json

{
  "timestamp": "...",
  "status": 400,
  "error": "Bad Request",
  "path": "/feedback"
}
🧪 How to Run Unit Tests
Unit testing is implemented for FeedbackService.saveFeedback().

To run the tests:

bash
mvn test

✅ Expected Output:
bash
[INFO] Tests run: 1, Failures: 0
[INFO] BUILD SUCCESS



