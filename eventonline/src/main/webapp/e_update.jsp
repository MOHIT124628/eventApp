<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Event</title>
    <style>
        body {
           font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .event-container {
            width: 100%;
            max-width: 600px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            display: grid;
            gap: 15px;
        }
        input[type="text"], input[type="submit"], input[type="button"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
            border: none;
            text-transform: uppercase;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-button {
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
            transition: background-color 0.3s ease;
            text-transform: uppercase;
            font-weight: bold;
        }
        .back-button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="event-container">
        <h1>Update Event</h1>
        
        <%-- Java code to retrieve eventid from URL and store in session --%>
        <%
            String eventIdStr = request.getParameter("eventid");
            
            if (eventIdStr != null && !eventIdStr.isEmpty()) {
                try {
                    int eventId = Integer.parseInt(eventIdStr);
                    // Store eventid in session
                    
                    session.setAttribute("eventId", eventId);
                } catch (NumberFormatException e) {
                    out.println("Invalid eventid provided.");
                }
            } else {
                out.println("Event ID not found in URL.");
            }
        %>
        
        <%-- Your HTML form for updating event details --%>
        <form action="updateEventServlet" method="post">
            <input type="hidden" name="eventid" value="<%= session.getAttribute("eventId") %>">
            <input type="text" name="eventname" placeholder="Event Name" >
            <input type="text" name="description" placeholder="Description" >
            <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 10px;">
                <input type="text" name="start_date" placeholder="Start Date (YYYY-MM-DD)" >
                <input type="text" name="end_date" placeholder="End Date (YYYY-MM-DD)" >
            </div>
            <input type="text" name="venuname" placeholder="Venue Name" >
            <input type="text" name="address" placeholder="Address" >
            <input type="number" name="total_seataval" placeholder="Total Seats Available" >
            <input type="number" name="price" placeholder="Price for a Ticket" >
            <input type="url" name="event_img" placeholder="Event Image URL" >
            <div style="display: flex; justify-content: space-between;">
                <input type="submit" value="Update Event">
                <a href="listEvents" class="back-button">Back</a>
            </div>
        </form>
    </div>
</body>
</html>
