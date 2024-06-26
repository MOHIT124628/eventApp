<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Event</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .event-container {
        background-color: #fff;
        padding: 20px 40px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
    }

    .event-container h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .event-container form {
        display: flex;
        flex-direction: column;
    }

    .event-container input[type="text"],
    .event-container input[type="submit"],
    .event-container input[type="button"] {
        margin-bottom: 15px;
        padding: 10px;
        font-size: 16px;
        border-radius: 5px;
        border: 1px solid #ccc;
        outline: none;
    }

    .event-container input[type="text"]:focus {
        border-color: #007bff;
    }

    .event-container input[type="submit"],
    .event-container input[type="button"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    .event-container input[type="submit"]:hover,
    .event-container input[type="button"]:hover {
        background-color: #0056b3;
    }

    .back-button {
        background-color: #6c757d;
    }

    .back-button:hover {
        background-color: #5a6268;
    }

    .event-container a {
        text-decoration: none;
    }

    .event-container a input[type="button"] {
        width: 100%;
        text-align: center;
        margin-top: 10px;
    }
</style>
</head>
<body>
    <div class="event-container">
        <h1>Create Events</h1>
        <form action="createEventServlet" method="post">
            <input type="text" name="eventname" placeholder="Event Name" required>
            <input type="text" name="description" placeholder="Description" required>
            <input type="text" name="start_date" placeholder="Start Date (YYYY-MM-DD)" required>
            <input type="text" name="end_date" placeholder="End Date (YYYY-MM-DD)" required>
            <input type="text" name="venuname" placeholder="Venue Name" required>
            <input type="text" name="address" placeholder="Address" required>
            <input type="number" name="total_seataval" placeholder="Total Seats Available" required>
            <input type="number" name="price" placeholder="Price for a Ticket" required>
            <input type="text" name="event_img" placeholder="Event Image URL" required>
            <input type="submit" value="Add Event">
            <a href="welcome.jsp"><input type="button" value="Back" class="back-button"></a>
        </form>
    </div>
</body>
</html>
