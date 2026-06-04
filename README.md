# ☁️ Smart Weather Alert System (Spring Boot)

A Spring Boot backend system that provides weather intelligence services based on user-defined locations.  
It integrates with an external Weather AI API and supports secure authentication, location management, and multiple weather views.

---

# 🚀 Features

## 👤 Authentication
- User registration
- User login/logout
- JWT-based authentication
- JWT stored securely in **HttpOnly cookies**
- Spring Security protected endpoints

---

## 📍 Location Management
- Create locations using city name
- System resolves latitude & longitude internally
- Locations are used for all weather queries

---

## 🌦 Weather Features

The system provides multiple weather endpoints:

### ✔ Current Weather


Returns real-time weather for a given location.

---

### ✔ Forecast Weather


Returns multi-day forecast with optional AI summary.

---

### ✔ Hourly Weather


Returns hourly weather breakdown for a location.

---

### ✔ Daily Weather


Returns daily weather summary for a location.

---

### ✔ General Weather Query


Returns weather data based on request parameters.

---

# 🔐 Security

This application uses:

- Spring Security
- JWT Authentication
- HttpOnly Cookies (secure token storage)
- Stateless authentication model

### Authentication Flow

1. User registers an account
2. User logs in
3. Server generates JWT token
4. JWT is stored in an HttpOnly cookie
5. Cookie is automatically sent on every request

---


---

# 🗄️ Database Configuration (MySQL)

Add the following in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

## 🧑‍💻 API Flow

This section explains the full user journey from authentication to weather retrieval.

---

## 1. Register User

```http
POST /auth/register

## 2. login
POST /auth/login

## 3. create location
POST /api/v1/locations
{
  "city": "Nairobi",
  "longitude" : "",
  "latitude" : "
}

## 4. get current weather
GET /api/v1/weather/current

## 5. get forecast
GET /api/v1/weather/forecast
{
  "city": "Nairobi",
  "days": 7,
  "ai": true
}

## 6. get hourly forecast
GET /api/v1/weather/hourly

## 7. get daily forecast
GET /api/v1/weather/daily
