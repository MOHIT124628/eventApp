Overview:
This document provides details on the MySQL database schema used in the Event Management System. It includes the structure of the tables, their relationships, and the sample SQL scripts to set up the database.

Database Schema:
Tables
The database consists of the following tables:

user
event
booking
reviews

Table Definitions
user
Columns:
userid (INT, PRIMARY KEY, AUTO_INCREMENT): Unique identifier for each user.
username (VARCHAR(255)): Username of the user.
password (VARCHAR(255)): Password of the user.
role (VARCHAR(50)): Role of the user (e.g., 'Owner', 'Attendee').

event
Columns:
eventid (INT, PRIMARY KEY, AUTO_INCREMENT): Unique identifier for each event.
eventname (VARCHAR(255)): Name of the event.
event_img (VARCHAR(255)): Image URL of the event.
venuname (VARCHAR(255)): Venue name where the event is held.
total_seataval (INT): Total seats available for the event.
price (DECIMAL(10, 2)): Price of the event ticket.
address (VARCHAR(255)): Address of the event venue.
start_date (DATE): Start date of the event.
end_date (DATE): End date of the event.
ownerid (INT, FOREIGN KEY): ID of the user who created the event.

booking
Columns:
bookingid (INT, PRIMARY KEY, AUTO_INCREMENT): Unique identifier for each booking.
eventid (INT, FOREIGN KEY): ID of the booked event.
userid (INT, FOREIGN KEY): ID of the user who booked the event.
booking_date (DATE): Date when the booking was made.

reviews
Columns:
reviewid (INT, PRIMARY KEY, AUTO_INCREMENT): Unique identifier for each review.
eventid (INT, FOREIGN KEY): ID of the reviewed event.
userid (INT, FOREIGN KEY): ID of the user who wrote the review.
rating (INT): Rating given by the user.
comment (TEXT): Review comment.


Sample SQL Scripts
Create Database and Tables

CREATE DATABASE e_book;

USE e_book;

CREATE TABLE user (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE event (
    eventid INT PRIMARY KEY AUTO_INCREMENT,
    eventname VARCHAR(255) NOT NULL,
    event_img VARCHAR(255) NOT NULL,
    venuname VARCHAR(255) NOT NULL,
    total_seataval INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    address VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    ownerid INT,
    FOREIGN KEY (ownerid) REFERENCES users(userid)
);

CREATE TABLE booking (
    bookingid INT PRIMARY KEY AUTO_INCREMENT,
    eventid INT,
    userid INT,
    booking_date DATE NOT NULL,
    FOREIGN KEY (eventid) REFERENCES events(eventid),
    FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE reviews (
    reviewid INT PRIMARY KEY AUTO_INCREMENT,
    eventid INT,
    userid INT,
    rating INT NOT NULL,
    comment TEXT,
    FOREIGN KEY (eventid) REFERENCES events(eventid),
    FOREIGN KEY (userid) REFERENCES users(userid)
);
Sample Data Insertion

-- Insert sample user
INSERT INTO users (username, password, role) VALUES ('john_doe', 'password123', 'Owner');
INSERT INTO users (username, password, role) VALUES ('jane_smith', 'password123', 'Attendee');

-- Insert sample event
INSERT INTO events (eventname, event_img, venuname, total_seataval, price, address, start_date, end_date, ownerid) 
VALUES ('Concert', 'img/concert.jpg', 'Music Hall', 100, 50.00, '123 Music Ave', '2024-07-01', '2024-07-02', 1);

-- Insert sample booking
INSERT INTO bookings (eventid, userid, booking_date) VALUES (1, 2, '2024-06-20');

-- Insert sample reviews
INSERT INTO reviews (eventid, userid, rating, comment) VALUES (1, 2, 5, 'Great concert!');


Usage
Setting Up: Run the provided SQL scripts to create the database and tables, and to insert sample data.
Integrating with Application: Use JDBC or an ORM like Hibernate to interact with the database from your Java application.
Session Management: Store and retrieve user and event data in the session for user-specific operations.

Conclusion
This README covers the essential aspects of the MySQL database schema used in the Event Management System, including table definitions, sample SQL scripts for database setup, and example data insertion. Use this document as a reference for setting up and managing the database for the system.
