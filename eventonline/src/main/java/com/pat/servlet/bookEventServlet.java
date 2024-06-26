package com.pat.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.bookingDAO;
import com.pat.DAOImp.bookingDAOImp;
import com.pat.DAOImp.eventDAOImp;
import com.pat.modren.bookings;
import com.pat.modren.event; // Ensure you import your event class here

@WebServlet("/bookEventServlet")
public class bookEventServlet extends HttpServlet {
    private bookingDAO book;

    @Override
    public void init() {
        book = new bookingDAOImp();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer eventId = (Integer) session.getAttribute("eventId");
        Integer userId = (Integer) session.getAttribute("userid");
        
        if (eventId == null || userId == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID or user ID.");
            return;
        }

        String uname = req.getParameter("uname");
        String uemail = req.getParameter("uemail");
        String phone_number_str = req.getParameter("phone_number");
        String number_ticketaval_str = req.getParameter("number_ticketaval");
        String totalprice_str = req.getParameter("totalprice");
        String booking_date = req.getParameter("booking_date");
        String paymentMethod = req.getParameter("paymentMethod");

        if (uname == null || uemail == null || phone_number_str == null || number_ticketaval_str == null ||
            totalprice_str == null || booking_date == null || paymentMethod == null ||
            phone_number_str.isEmpty() || number_ticketaval_str.isEmpty() || totalprice_str.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
            return;
        }

        long phone_number = Long.parseLong(phone_number_str);

        int number_ticketaval = Integer.parseInt(number_ticketaval_str);
        

        double totalprice = Double.parseDouble(totalprice_str);
        

        // Assuming you have an eventDAO and eventDAOImp for retrieving event details
        event eventDetails = null;
        
            eventDAOImp eventDao = new eventDAOImp();
            try {
				eventDetails = eventDao.getEventById(eventId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (eventDetails == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Event not found.");
                return;
            }
       
        bookings booking = new bookings();
        booking.setE_eventid(eventId);
        booking.setU_userid(userId);
        booking.setUname(uname);
        booking.setUemail(uemail);
        booking.setPhone_number(phone_number);
        booking.setNumber_ticketaval(number_ticketaval);
        booking.setTotalprice(totalprice);
        booking.setBooking_date(booking_date);
        booking.setPayment_mode(paymentMethod);

        book.save(booking);
		resp.sendRedirect("bookingSuccess.jsp"); // Redirect to a confirmation page or event list
    }
}
