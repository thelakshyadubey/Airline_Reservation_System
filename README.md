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
![image](https://github.com/user-attachments/assets/2346874b-b160-4f31-83ab-3fa39f6c4e77)
![image](https://github.com/user-attachments/assets/eef628c9-e26b-42f1-94cd-f822c60acab2)
![image](https://github.com/user-attachments/assets/114b8a3d-3633-4756-9200-b82e4bd5b6b5)
![image](https://github.com/user-attachments/assets/b3bfbef2-df77-40ca-96f4-fde3e069deb3)
![image](https://github.com/user-attachments/assets/214b3b4c-7197-447c-a9d0-64d8a081186c)
![image](https://github.com/user-attachments/assets/c7a47830-51e5-4f41-ad5d-da134e9f769e)
![image](https://github.com/user-attachments/assets/26a4ee4a-06ff-47ce-a8fa-f91d71ed72eb)





