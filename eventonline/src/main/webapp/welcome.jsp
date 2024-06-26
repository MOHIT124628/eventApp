<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pat.modren.event" %>
<%@ page import="com.pat.modren.user" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #240750;
            color: white;
            padding: 15px 20px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .nav-links {
            margin: 20px 0;
            text-align: center;
        }
        .nav-links a {
            margin: 0 10px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            padding: 8px 16px;
            border-radius: 4px;
            transition: background-color 0.3s;
            background-color: #007bff;
        }
        .nav-links a:hover {
            background-color: #0056b3;
        }
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .event-list {
            margin-top: 20px;
        }
        .eventadder {
            position: relative;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            padding: 15px;
            margin-bottom: 20px;
        }
        .eventadder img {
            width: 150px;
            height: 100px;
            object-fit: cover;
            border-radius: 5px;
            margin-right: 15px;
        }
        .eventadder h3 {
            margin-top: 0;
            margin-bottom: 5px;
        }
        .eventadder h4 {
            color: #888;
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 14px;
        }
        .eventadder p {
            margin: 0;
            color: #444;
        }
        .button-align,
        .button-align1 {
            display: none; /* Initially hide buttons */
            padding: 8px 16px;
            background-color: #41C1F2;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .button-align:hover,
        .button-align1:hover {
            background-color: #1a8dc8;
        }
        .button-align {
            position: absolute;
            top: 10px;
            right: 110px;
        }
        .button-align1 {
            position: absolute;
            top: 10px;
            right: 10px;
            margin-left: 10px; /* Adjust margin between buttons */
        }
        .update-link, .delete-link {
            text-decoration: none;
            color: white;
        }
        <%-- Style for logged-in user buttons --%>
        <% if (session.getAttribute("user") != null) { %>
        .button-align.visible,
        .button-align1.visible {
            display: inline-block; /* Display buttons when user is logged in */
        }
        <% } %>
    </style>
</head>
<body>
<header>
    <h1>Welcome to Our Event Platform</h1>
</header>
<div class="nav-links">
    <% 
    user us = (user) session.getAttribute("user");
    if (us == null) { %>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Register</a>
    <% } else { %>
    <% if ("Owner".equals(us.getRole())) { %>
    <a href="e_create.jsp">Add Event</a>
    <a href="#">Update Event</a>
    <a href="logout">Logout</a>
    <% } else { %>
    <a href="logout">Logout</a>
    <a href="bookingHistory">History</a>
    <h1>Do Enjoy The Event :)</h1>
    <% } %>
    <% } %>
</div>
<div class="container">
    <h2>Events Available</h2>
    <section class="event-list">
        <% 
        List<event> evs = (List<event>) session.getAttribute("events");
        if (evs != null && !evs.isEmpty()) {
        for (event eve : evs) {
        %>
        <div class="eventadder">
            <img src="<%= eve.getEvent_img() %>" alt="Image of <%= eve.getEventname() %>" />
            <div>
                <h3><%= eve.getEventname() %></h3>
                <h4><%= eve.getVenuname() %> - Total Seats: <%= eve.getTotal_seataval() %></h4>
                <p>Price: <%= eve.getPrice() %></p>
                <p>Address: <%= eve.getAddress() %></p>
                <p>Start Date: <%= eve.getStart_date() %></p>
                <p>End Date: <%= eve.getEnd_date() %></p>
            </div>
            <% if (us != null) { %>
            <% if ("Owner".equals(us.getRole())) { %>
            <div class="button-align visible">
                <a href="e_update.jsp?eventid=<%= eve.getEventid() %>" class="update-link">Update</a>
            </div>
            <div class="button-align1 visible">
                <a href="e_delete.jsp?eventid=<%= eve.getEventid() %>" class="delete-link">Delete</a>
            </div>
            <% } else { %>
            <div class="button-align visible">
                <a href="e_bookevent.jsp?eventid=<%= eve.getEventid() %>" class="update-link">Book Event</a>
            </div>
            <div class="button-align1 visible">
                <a href="e_viewevent.jsp?eventid=<%= eve.getEventid() %>" class="delete-link">View Event</a>
            </div>
            <% } %>
            <% } %>
        </div>
        <% 
        }
        } else { 
        %>
        <p>No events available.</p>
        <% } %>
    </section>
</div>
</body>
</html>
