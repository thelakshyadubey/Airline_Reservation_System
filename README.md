# Airline Reservation System

![Java](https://img.shields.io/badge/Java-17-blue) 
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange) 
![Swing](https://img.shields.io/badge/GUI-Swing-yellowgreen)

A complete desktop application for airline ticket booking and management built with Java Swing and MySQL.

## Key Features

- User registration and secure login system
- Flight search and booking functionality
- Passenger details management
- Booking status tracking
- Booking cancellation system
- Flight information display
- Input validation for all fields

## System Components

1. **User Module**
   - New user registration
   - Login/logout functionality
   - Profile management

2. **Booking Module**
   - Ticket booking with passenger details
   - Booking confirmation
   - Booking status check
   - Booking cancellation

3. **Flight Module**
   - Flight information display
   - Search by destination
   - Fare details

## Technical Specifications

- Developed in Java using Swing for GUI
- MySQL database backend
- JDBC for database connectivity
- MVC architecture pattern
- Input validation for all user entries

## Installation Guide

1. **Prerequisites**:
   - Java Runtime Environment (JRE) 17 or later
   - MySQL Server 8.0
   - MySQL Connector/J

2. **Database Setup**:
   - Import the provided SQL file into your MySQL server

3. **Configuration**:
   - Update database connection details in the code if needed:
     ```java
     myobj = DriverManager.getConnection("jdbc:mysql://localhost/ars", "username", "password");
     ```

4. **Running the Application**:
   - Compile and execute the AirlineReservationSystem.java file

## Usage Instructions

1. **Login Screen**:
   - Enter credentials for existing users
   - Register new account if needed

2. **Main Menu**:
   - Book Tickets: Make new flight reservations
   - Flight Info: View available flights
   - Booking Status: Check existing bookings
   - Cancel Booking: Cancel reservations
   - Logout: Exit the system

3. **Booking Process**:
   - Fill passenger details (name, age, gender)
   - Provide Aadhar card number (12 digits)
   - Select destination and travel date
   - Choose seating class (Economy/Business)
   - Confirm booking

## Validation Features

- Aadhar number validation (12 digits)
- Contact number validation (10 digits)
- Email format validation
- Date format validation (YYYY-MM-DD)
- Future date checking
- Mandatory field checking

## Developer Information

- Developed by: Lakshya Dubey

## Preview
