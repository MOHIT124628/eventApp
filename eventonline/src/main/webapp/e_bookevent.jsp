<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pat.modren.event"%>
<%@ page import="com.pat.DAO.eventDAO"%>
<%@ page import="com.pat.DAOImp.eventDAOImp"%>
<%@ page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Event</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .booking-container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1, h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            display: grid;
            grid-gap: 10px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="number"], input[type="date"], input[type="submit"], select {
            width: calc(100% - 22px); /* Adjusted for padding */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function calculateTotalPrice() {
            const pricePerTicket = parseFloat(document.getElementById('pricePerTicket').value);
            const numberOfTickets = parseInt(document.getElementById('number_ticketaval').value);
            const totalPrice = pricePerTicket * numberOfTickets;
            document.getElementById('totalprice').value = totalPrice.toFixed(2);
        }
    </script>
</head>
<body>
    <div class="booking-container">
        <h1>Book Event</h1>
        
        <%-- Java code to retrieve eventid from URL and store in session --%>
        <%
        Integer eventId = null;
        try {
            eventId = Integer.parseInt(request.getParameter("eventid"));
            // Store eventid in session
            session.setAttribute("eventId", eventId);
        } catch (NumberFormatException e) {
            out.println("Invalid eventid provided.");
        }

        event eventDetails = null;
        if (eventId != null) {
            try {
                eventDAO eventDao = new eventDAOImp();
                eventDetails = eventDao.getEventById(eventId);
                if (eventDetails == null) {
                    out.println("Event not found.");
                } else {
                    // Store event details in session
                    session.setAttribute("eventName", eventDetails.getEventname());
                    session.setAttribute("eventImage", eventDetails.getEvent_img());
                }
            } catch (SQLException e) {
                out.println("Database error.");
            }
        } else {
            out.println("Event ID not found in URL.");
        }
        %>
        
        <% if (eventDetails != null) { %>
            <h2>Event: <%= eventDetails.getEventname() %></h2>
            <img src="<%= eventDetails.getEvent_img() %>" alt="Image of <%= eventDetails.getEventname() %>" style="max-width: 100%; height: auto;">
            <form action="bookEventServlet" method="post">
                <input type="hidden" name="eventid" value="<%= session.getAttribute("eventId") %>">
                
                <label for="uname">Your Name:</label>
                <input type="text" id="uname" name="uname" placeholder="Your Name" required>
                
                <label for="uemail">Your Email:</label>
                <input type="email" id="uemail" name="uemail" placeholder="Your Email" required>
                
                <label for="phone_number">Phone Number:</label>
                <input type="text" id="phone_number" name="phone_number" placeholder="Your Phone Number" required>
                
                <label for="number_ticketaval">Number of Tickets:</label>
                <input type="number" id="number_ticketaval" name="number_ticketaval" placeholder="Number of Tickets" required oninput="calculateTotalPrice()">
                
                <label for="pricePerTicket">Price per Ticket:</label>
                <input type="hidden" id="pricePerTicket" value="<%= eventDetails.getPrice() %>">
                
                <label for="totalprice">Total Price:</label>
                <input type="number" id="totalprice" name="totalprice" placeholder="Total Price" readonly>
                
                <label for="booking_date">Booking Date:</label>
                <input type="date" id="booking_date" name="booking_date" required>
                
                <label for="paymentMethod">Payment Method:</label>
                <select id="paymentMethod" name="paymentMethod" required>
                    <option value="cash">Cash</option>
                    <option value="upi">UPI</option>
                    <option value="card">Card</option>
                </select>
                
                <input type="submit" value="Book Event">
            </form>
        <% } %>
    </div>
</body>
</html>
