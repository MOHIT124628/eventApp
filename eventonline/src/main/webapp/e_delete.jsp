<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pat.modren.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Event</title>
    <style>
       body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            text-align: center;
        }
        input[type="submit"] {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #c82333;
        }
        p {
            text-align: center;
            margin-top: 20px;
        }
        a {
            color: #007bff;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #0056b3;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Delete Event</h1>
    
    <%-- Retrieve eventid from request parameter --%>
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
    
    <p>Are you sure you want to delete this event?</p>
    
    <form action="deleteEventServlet" method="post">
        <input type="hidden" name="eventid" value="<%= session.getAttribute("eventId") %>">
        <input type="submit" value="Delete">
    </form>
    
    <p><a href="listEvents">Cancel and go back to Events List</a></p>
    
</body>
</html>
