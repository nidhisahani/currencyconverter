# Currency Converter API

## Overview
The **Currency Converter API** is a Spring Boot application that integrates with a public exchange rate API to provide real-time currency conversion functionality. The application exposes RESTful endpoints to fetch exchange rates and convert amounts between currencies.

## Features
- Fetch exchange rates for a given base currency.
- Convert amounts between currencies using real-time exchange rates.
- Handles invalid inputs and API errors gracefully.
- Includes Swagger documentation for easy API exploration.

---

## Prerequisites
- **Java 17** or higher
- **Maven 3.6** or higher
- **Internet connection** (to access the external exchange rate API)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone "https://github.com/nidhisahani/currencyconverter"
cd currencyconverter
```

### 2. Configure the Application
Update the application.properties file with your API key and configurations:
```bash
exchange.api.url=https://api.exchangerate.host/latest
exchange.api.key=YOUR_API_KEY
server.port=8080
springdoc.swagger-ui.path=/swagger-ui.html

```
### 3. Build the Application
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```


---

### Key Points Included:
1. **Setup instructions**: Clone, configure, build, and run the application.
2. **API documentation**: Examples for both endpoints.
3. **Error handling**: Describes how errors are handled.
4. **Testing**: Instructions to run unit tests.
5. **Swagger UI**: Location and usage.
6. **Directory structure**: Overview of the project structure.

Let me know if you'd like further customization!
