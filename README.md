# Airways Ticket Booking System

## Overview
Airways Ticket Booking System is a full-stack Java application for managing airline ticket bookings. The project allows users to search for flights, book tickets, view their booking history, and manage their profiles. It also provides admin functionalities such as managing flights and monitoring bookings.

This project is designed with modular architecture and uses a secure backend system to ensure the integrity and confidentiality of user data.

---

## Features

### **User Features**
- **Flight Search**: Users can search for available flights by destination, departure date, and other filters.
- **Ticket Booking**: Users can book tickets for selected flights.
- **Booking History**: View the user's past bookings with filtering options.
- **Profile Management**: Users can view and update their personal profile.
- **Authentication and Authorization**:
  - Registration and login using JWT (Bearer Token).
  - Role-based access (User, Admin).

### **Admin Features**
- **Flight Management**: Admins can add, update, and delete flights.
- **Booking Management**: Admins can monitor all bookings made by users.

---

## Technologies Used

### **Programming Language**
- **Java 21**

### **Frameworks and Libraries**
- **Spring Boot 3.1**: Core framework for building the application.
- **Hibernate (JPA)**: For ORM and database interaction.
- **MapStruct**: For mapping DTOs to Entities and vice versa.
- **Lombok**: For reducing boilerplate code (e.g., getters, setters, constructors).
- **Swagger**: For API documentation and testing.
- **JWT**: For user authentication and authorization.
- **Validator**: For validating user input.

### **Database**
- **PostgreSQL**: Used as the relational database to store application data.

### **Build Tool**
- **Gradle**: For building and managing dependencies.

