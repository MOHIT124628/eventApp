<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pat.modren.bookings" %>
<%@ page import="com.pat.modren.event" %>
<%@ page import="com.pat.DAO.eventDAO" %>
<%@ page import="com.pat.DAOImp.eventDAOImp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking History</title>
    <style>
        /* CSS styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
            margin: 0;
            color: #333;
        }

        .booking-history {
            max-width: 900px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #555;
            margin-bottom: 20px;
        }

        .booking-item {
            display: flex;
            align-items: center;
            background-color: #f9f9f9;
            border-radius: 8px;
            margin-bottom: 20px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .booking-item .booking-info {
            flex: 1;
            padding: 20px;
        }

        .booking-item .booking-info .event-name {
            font-size: 22px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        .booking-item .booking-info .event-name a {
            color: #333;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .booking-item .booking-info .event-name a:hover {
            color: #00bcd4;
        }

        .booking-item .booking-info .event-details {
            margin-bottom: 10px;
            font-size: 16px;
            color: #666;
        }

        .booking-item .booking-info .event-description {
            margin-bottom: 10px;
            color: #777;
            text-align: justify;
        }

        .booking-item .booking-info .event-image {
            width: 150px;
            height: 150px;
            flex-shrink: 0;
            overflow: hidden;
            border-radius: 8px;
        }

        .booking-item .booking-info .event-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 8px;
        }

        @media screen and (max-width: 768px) {
            .booking-history {
                padding: 15px;
            }

            .booking-item {
                flex-direction: column;
            }

            .booking-item .booking-info {
                padding: 15px;
                text-align: center;
            }

            .booking-item .booking-info .event-image {
                width: 100%;
                height: auto;
                margin-bottom: 10px;
            }
        }
        .event-image img {
    		width: 250px;
    		height: 250px; /* Adjust the height to your preferred size */
    		object-fit: cover;
    		border-radius: 8px;
    		border:20px soild white;
	}
        .review-button {
    margin-top: 10px; /* Adjust margin as needed */
    text-align: center;
    
	}

.review-link {
    display: inline-block;
    padding: 10px 20px;
    margin-top: 12px;
    background-color: #007bff; /* Blue color */
    color: #fff; /* White text color */
    text-decoration: none; /* Remove underline */
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.review-link:hover {
    background-color: #0056b3; /* Darker shade of blue on hover */
}
.event-details{
	padding-top: 10px;
}
        
    </style>
</head>
<body>
    <h1>Booking History</h1>
    <div class="booking-history">
        <% 
        List<bookings> bookings = (List<bookings>) request.getAttribute("bookings"); 
        if (bookings != null && !bookings.isEmpty()) { 
            eventDAO eventDao = new eventDAOImp();
            for (bookings booking : bookings) {
                event eventDetails = eventDao.getEventById(booking.getE_eventid());
                if (eventDetails != null) {
        %>
        <div class="booking-item">
            <div class="booking-info">
                <div class="event-name"><a href="<%= eventDetails.getEvent_img() %>" target="_blank"><%= eventDetails.getEventname() %></a></div>
                <div class="event-details">
                    <div><strong>Booking ID:</strong> <%= booking.getBookingid() %></div>
                    <div><strong>User ID:</strong> <%= booking.getU_userid() %></div>
                    <div><strong>Name:</strong> <%= booking.getUname() %></div>
                    <div><strong>Email:</strong> <%= booking.getUemail() %></div>
                    <div><strong>Phone Number:</strong> <%= booking.getPhone_number() %></div>
                    <div><strong>Number of Tickets:</strong> <%= booking.getNumber_ticketaval() %></div>
                    <div><strong>Total Price:</strong> <%= booking.getTotalprice() %></div>
                    <div><strong>Booking Date:</strong> <%= booking.getBooking_date() %></div>
                    <div><strong>Payment Mode:</strong> <%= booking.getPayment_mode() %></div>
                    <div><a href="reviewForm.jsp?eventid=<%= booking.getE_eventid() %>&userid=<%= booking.getU_userid() %>" class="review-link" >Give Review</a></div>
                </div>
                <div class="event-description"><%= eventDetails.getDescription() %></div>
            </div>
            <div class="event-image">
                <img src="<%= eventDetails.getEvent_img() %>" alt="<%= eventDetails.getEventname() %> Image">
            </div>
        </div>
        <% 
                }
            } 
        } else { 
        %>
        <div>No bookings found</div>
        <% } %>
    </div>
</body>
</html>
