<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pat.modren.*" %>
<%@ page import="com.pat.DAO.*" %>
<%@ page import="com.pat.DAOImp.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event Details</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .event-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .event-header {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .event-content {
            display: flex;
        }
        .event-img {
            flex: 0 0 200px;
            text-align: center;
            margin-right: 20px;
        }
        .event-img img {
            max-width: 100%;
            border-radius: 8px;
        }
        .event-details {
            flex: 1;
            display: flex;
            flex-direction: column;
        }
        .event-details h2 {
            margin-top: 0;
            color: #007bff;
        }
        .event-details .description {
            margin-top: 20px;
        }
        .event-dates {
            margin-top: auto;
        }
        .event-details p {
            margin: 10px 0;
            line-height: 1.6;
        }
        .no-event-msg {
            text-align: center;
            padding: 20px;
            color: #888;
        }
        
        .reviews {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .reviews h3 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .review-container {
            display: flex;
            flex-direction: column;
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 20px;
            background-color: #f9f9f9;
        }

        .review-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .review-header p {
            margin: 0;
            font-weight: bold;
            color: #333;
        }

        .review-description {
            margin: 0;
            color: #555;
        }

        .stars-outer {
            display: inline-block;
            position: relative;
            font-family: FontAwesome;
        }

        .stars-outer::before {
            content: "\f005 \f005 \f005 \f005 \f005";
            font-family: FontAwesome;
            color: #ccc;
        }

        .stars-inner {
            position: absolute;
            top: 0;
            left: 0;
            white-space: nowrap;
            overflow: hidden;
            width: 0;
            color: #f8ce0b;
        }

        .stars-inner::before {
            content: "\f005 \f005 \f005 \f005 \f005";
            font-family: FontAwesome;
        }

        hr {
            border: 0;
            height: 1px;
            background: #ccc;
            margin: 20px 0;
        }
    </style>
    <!-- Load FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   </head>
<body>
    <div class="event-container">
        <h1 class="event-header">Event Details</h1>
        
        <%-- Retrieve event details based on eventid --%>
        <%
        int eventid = 0;
        try {
            eventid = Integer.parseInt(request.getParameter("eventid"));
        } catch (NumberFormatException e) {
            out.println("Invalid eventid provided.");
        }

        // Retrieve event details from DAO
        event eventDetails = null;
        if (eventid != 0) {
            eventDAO eventDao = new eventDAOImp();
            try {
                eventDetails = eventDao.getEventById(eventid);
            } catch (SQLException e) {
                out.println("Database error: " + e.getMessage());
            }
        } else {
            out.println("Event ID not found in URL.");
        }
        %>
        
        <% if (eventDetails != null) { %>
            <div class="event-content">
                <div class="event-img">
                    <img src="<%= eventDetails.getEvent_img() %>" alt="Event Image">
                    <div class="event-dates">
                        <p><strong>Start Date:</strong> <%= eventDetails.getStart_date() %></p>
                        <p><strong>End Date:</strong> <%= eventDetails.getEnd_date() %></p>
                    </div>
                </div>
                <div class="event-details">
                    <h2><%= eventDetails.getEventname() %></h2>
                    <div class="description">
                        <p><strong>Description:</strong></p>
                        <p><%= eventDetails.getDescription() %></p>
                    </div>
                </div>
            </div>
        <% } else { %>
            <div class="no-event-msg">
                <p>No event found for Event ID <%= eventid %>.</p>
            </div>
        <% } %>
        
        <%-- Retrieve reviews for the event from DAO --%>
        <%
        List<reviews> reviewsList = new ArrayList<>();
        reviewsDAO reviewsDao = new reviewsDAOImp();
        
       
            reviewsList = reviewsDao.getReviewsByEventId(eventid);
       
        %>
        
       <div class="reviews">
        <h3>Reviews</h3>
        <% if (!reviewsList.isEmpty()) { %>
            <% for (reviews review : reviewsList) { 
                try {
                    // Convert the rating from String to float
                    int rating =review.getRating();
                    double ratingPercentage = (rating / 5.0) * 100;
            %>
                <div class="review-container">
                    <div class="review-header">
                        <p><strong>Name:</strong> <%= review.getU_name() %></p>
                        <div class="stars-outer">
                            <div class="stars-inner" style="width: <%= ratingPercentage %>%"></div>
                        </div>
                    </div>
                    <p class="review-description"><strong>Description:</strong> <%= review.getDecsription() %></p>
                </div>
                <hr>
            <% 
                } catch (NumberFormatException e) {
                    // Handle the case where the rating is not a valid float
            %>
                <div class="review-container">
                    <div class="review-header">
                        <p><strong>Name:</strong> <%= review.getU_name() %></p>
                        <p><strong>Rating:</strong> Invalid rating</p>
                    </div>
                    <p class="review-description"><strong>Description:</strong> <%= review.getDecsription() %></p>
                </div>
                <hr>
            <% 
                }
            } %>
        <% } else { %>
            <p>No reviews yet.</p>
        <% } %>
    </div>
    </div>
</body>
</html>
