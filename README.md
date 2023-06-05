# Flight Ticket Booking Application

This application is a robust flight ticket booking system, featuring both backend and frontend functionalities, albeit the frontend part is still under development. The system implements a role-based authentication mechanism, facilitating admin-level and user-level interactions differently.

## Running the Application

Navigate to the backend directory and start the spring boot application using the following commands:

```bash
cd backend
mvn spring-boot:run
```

## Features

The application offers a suite of API endpoints including `AirportController`, `PlaneController`, `FlightExpeditionController`, `BookingController`, and `PassengerController`. Administrators can perform CRUD operations on these APIs. User-level interactions are primarily read operations, with create, delete, and update operations typically restricted.

A JWT-based access and refresh token system is implemented. When a user session expires on the frontend, an automatic refresh token request is triggered. The application also incorporates the Stripe payment system, enabling secure processing of flight purchases and providing a detailed record of transactions in the Stripe control panel.

The frontend, developed using React.js, incorporates technologies such as Redux and Axios, and includes features like user pages, sign-in, sign-up, flight search, etc. However, it's currently a work in progress.

## Requirements

For building and running the application you'll need:

- Spring Boot 2.5.6
- JDK 8 
- Maven 3.8.3
- Swagger UI Documentation
- Postgresql

## Backend

The application's backend has been built using several modern technologies and best practices:

- Developed using Spring Boot.
- Adheres to SOLID principles for a maintainable and flexible codebase.
- Employs JPA for efficient database operations.
- Utilizes MapStruct for conversion between models and entities.
- Incorporates Role-Based Authentication for differential access levels.
- Implements JWT for secure access and refresh tokens.
- Integrates with Stripe for secure payment processing.

## Swagger UI Documentation

You can access the Swagger UI documentation for detailed information about the application's API endpoints. After starting the application, open your browser and navigate to the local URL for Swagger UI.

## Frontend (Under Development)

Frontend development is still ongoing. Current features include:

- Built with React.js.
- Uses Redux for state management.
- JWT-based access and refresh token system for API requests.
- User pages, Sign-in, Sign-up, Flight Search, and more created using HTML, CSS, Bootstrap, and jQuery.

