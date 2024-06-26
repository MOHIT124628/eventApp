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
    FOREIGN KEY (ownerid) REFERENCES user(userid)
);

CREATE TABLE booking (
    bookingid INT PRIMARY KEY AUTO_INCREMENT,
    eventid INT,
    userid INT,
    booking_date DATE NOT NULL,
    FOREIGN KEY (eventid) REFERENCES event(eventid),
    FOREIGN KEY (userid) REFERENCES user(userid)
);

CREATE TABLE reviews (
    reviewid INT PRIMARY KEY AUTO_INCREMENT,
    eventid INT,
    userid INT,
    rating INT NOT NULL,
    comment TEXT,
    FOREIGN KEY (eventid) REFERENCES event(eventid),
    FOREIGN KEY (userid) REFERENCES user(userid)
);
Sample Data Insertion

-- Insert sample user
INSERT INTO user (userid, name, username, password, email, phone_number, city, role, created_date, last_date) VALUES
(1, 'John Doe', 'johndoe', 'password123', 'johndoe@example.com', '123-456-7890', 'New York', 'customer', '2023-01-01 12:00:00', '2024-01-01 12:00:00'),
(2, 'Jane Smith', 'janesmith', 'password456', 'janesmith@example.com', '234-567-8901', 'Los Angeles', 'customer', '2023-02-01 13:00:00', '2024-02-01 13:00:00'),
(3, 'Alice Johnson', 'alicej', 'password789', 'alicej@example.com', '345-678-9012', 'Chicago', 'Owner', '2023-03-01 14:00:00', '2024-03-01 14:00:00'),
(4, 'Bob Brown', 'bobbrown', 'password321', 'bobbrown@example.com', '456-789-0123', 'Houston', 'customer', '2023-04-01 15:00:00', '2024-04-01 15:00:00'),
(5, 'Charlie Davis', 'charlied', 'password654', 'charlied@example.com', '567-890-1234', 'Phoenix', 'Owner', '2023-05-01 16:00:00', '2024-05-01 16:00:00'),
(6, 'Dana White', 'danawhite', 'password987', 'danawhite@example.com', '678-901-2345', 'Philadelphia', 'customer', '2023-06-01 17:00:00', '2024-06-01 17:00:00');


-- Insert sample event
INSERT INTO event (eventid, eventname, description, start_date, end_date, venuname, address, total_seataval, event_img, price) VALUES
(1, 'Summer Music Festival', 'Join us for the hottest music event of the season!', '2023-07-15', '2023-07-17', 'Central Park', '123 Central Park West, New York', '5000', 'summer_music_festival.jpg', 49.99),
(2, 'Tech Conference 2023', 'Discover the latest in technology and innovation.', '2023-08-20', '2023-08-22', 'Convention Center', '456 Tech Boulevard, San Francisco', '1000', 'tech_conference_2023.jpg', 199.99),
(3, 'Food Festival', 'Explore a variety of delicious cuisines from around the world.', '2023-09-10', '2023-09-12', 'Downtown Square', '789 Main Street, Chicago', '3000', 'food_festival.jpg', 29.99),
(4, 'Art Exhibition', 'Experience stunning artworks by renowned artists.', '2023-10-05', '2023-10-07', 'Art Gallery', '101 Art Avenue, Miami', '800', 'art_exhibition.jpg', 19.99),
(5, 'Sports Tournament', 'Compete in various sports disciplines and win prizes.', '2023-11-15', '2023-11-17', 'Sports Complex', '202 Sports Drive, Dallas', '2000', 'sports_tournament.jpg', 39.99),
(6, 'Fashion Show', 'Witness the latest fashion trends on the runway.', '2023-12-01', '2023-12-03', 'Fashion Center', '303 Fashion Avenue, Los Angeles', '1500', 'fashion_show.jpg', 59.99);


-- Insert sample booking
INSERT INTO booking (bookingid, e_eventid, u_userid, uname, uemail, phone_number, number_ticketaval, totalprice, booking_date, payment_mode) VALUES
(1, 1, 1, 'John Doe', 'johndoe@example.com', 1234567890, 2, 99.98, '2023-07-16', 'card'),
(2, 2, 2, 'Jane Smith', 'janesmith@example.com', 2345678901, 1, 199.99, '2023-08-21', 'upi'),
(3, 3, 3, 'Alice Johnson', 'alicej@example.com', 3456789012, 4, 119.96, '2023-09-11', 'card'),
(4, 4, 4, 'Bob Brown', 'bobbrown@example.com', 4567890123, 3, 59.97, '2023-10-06', 'cash'),
(5, 5, 5, 'Charlie Davis', 'charlied@example.com', 5678901234, 5, 199.95, '2023-11-16', 'card'),
(6, 6, 6, 'Dana White', 'danawhite@example.com', 6789012345, 2, 119.98, '2023-12-02', 'upi');


-- Insert sample reviews
INSERT INTO reviews (reviewid, evid, usid, u_name, u_email, rating, title, decsription) VALUES
(1, 1, 1, 'John Doe', 'johndoe@example.com', 4, 'Great Event!', 'Enjoyed the music and atmosphere.'),
(2, 2, 2, 'Jane Smith', 'janesmith@example.com', 5, 'Excellent Conference', 'Very informative sessions and great networking opportunities.'),
(3, 3, 3, 'Alice Johnson', 'alicej@example.com', 3, 'Good Food Variety', 'Could have more vegetarian options.'),
(4, 4, 4, 'Bob Brown', 'bobbrown@example.com', 5, 'Impressive Artworks', 'Loved the creativity and diversity of the artworks.'),
(5, 5, 5, 'Charlie Davis', 'charlied@example.com', 4, 'Exciting Tournament', 'Well-organized event with competitive spirit.'),
(6, 6, 6, 'Dana White', 'danawhite@example.com', 5, 'Stylish Fashion Show', 'Incredible designs and talented models.');



Usage
Setting Up: Run the provided SQL scripts to create the database and tables, and to insert sample data.
Integrating with Application: Use JDBC or an ORM like Hibernate to interact with the database from your Java application.
Session Management: Store and retrieve user and event data in the session for user-specific operations.

Conclusion
This README covers the essential aspects of the MySQL database schema used in the Event Management System, including table definitions, sample SQL scripts for database setup, and example data insertion. Use this document as a reference for setting up and managing the database for the system.
