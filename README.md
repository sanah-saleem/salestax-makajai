# 🛒 Sales Tax Calculator - Spring Boot

A Spring Boot application that calculates sales tax for a list of products, following **TDD (Test-Driven Development)** principles.  
Supports unit tests, validations, and is fully containerized with Docker for easy deployment.

---

## 🚀 Features
- REST API endpoint to generate receipts with sales tax.
- Validations for product details.
- Global exception handling with custom error messages.
- Constants for maintainable and reusable messages.
- Unit tests for service and utility functions.
- Dockerized for easy sharing and deployment.

---

## 📦 Technologies Used
- **Java 17**
- **Spring Boot 3.x**
- **JUnit 5**
- **Lombok**
- **Maven**
- **Docker**

---

## 📜 Tax Rules

- **Basic Sales Tax**: 10% on all goods except **books**, **food**, and **medical products** (exempt).  
- **Import Duty**: Additional 5% on all imported goods (**no exemptions**).  
- **Rounding Rule**: Sales tax is **rounded up** to the nearest `0.05`.  
- **Receipt Includes**:  
  1. Price per item (including tax)  
  2. Total sales tax paid  
  3. Final total price  

---

## To run the application
```bash
docker run -p 8080:8080 sanah22/sales-tax-app:v1
```

---

## 📡 API Endpoint

**POST** `/receipt`  
Generates a receipt for given products with sales tax applied.

### Request Body
```json
[
    {
        "name": "Book",
        "price": 12.49,
        "imported": false,
        "category": "BOOKS",
        "quantity": 1
    },
    {
        "name": "Imported Chocolate",
        "price": 10.00,
        "imported": true,
        "category": "FOOD",
        "quantity": 1
    }
]
```

### Response
```json
{
    "lines": [
        {
            "description": "1 Book",
            "priceWithTax": 12.49
        },
        {
            "description": "1 Imported Chocolate",
            "priceWithTax": 10.50
        }
    ],
    "totalSalesTax": 0.50,
    "total": 22.99
}
```

---

##🧪 Running Tests
```bash
mvn test
```

---

## 👨‍💻 Author
**Sanah Saleem**  
📧 sanahsaleem2000@gmail.com
