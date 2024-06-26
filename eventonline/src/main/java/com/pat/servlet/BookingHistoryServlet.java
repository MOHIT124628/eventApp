package com.pat.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.*;
import com.pat.DAOImp.bookingDAOImp;
import com.pat.modren.bookings;

@WebServlet("/bookingHistory")
public class BookingHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private bookingDAO bookingDAO;

    public void init() {
        bookingDAO = new bookingDAOImp(); // Instantiate your DAO implementation
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve list of bookings from DAO
        List<bookings> bookings = bookingDAO.getAllBookings(); // Implement this method in your DAO

        
       
        // Print bookings to console
//        System.out.println("Printing Booking History:");
//        for (bookings booking : bookings) {
//            System.out.println("Booking ID: " + booking.getBookingid());
//            System.out.println("Event ID: " + booking.getE_eventid());
//            System.out.println("User ID: " + booking.getU_userid());
//            System.out.println("Name: " + booking.getUname());
//            System.out.println("Email: " + booking.getUemail());
//            System.out.println("Phone Number: " + booking.getPhone_number());
//            System.out.println("Number of Tickets: " + booking.getNumber_ticketaval());
//            System.out.println("Total Price: " + booking.getTotalprice());
//            System.out.println("Booking Date: " + booking.getBooking_date());
//            System.out.println("Payment Mode: " + booking.getPayment_mode());
//            System.out.println();
//        }

        // Forward to JSP to display booking history
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("booking_history.jsp").forward(request, response);
    }
}
