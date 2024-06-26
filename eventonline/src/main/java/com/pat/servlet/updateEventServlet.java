package com.pat.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.eventDAO;
import com.pat.DAOImp.eventDAOImp;
import com.pat.modren.event;

@WebServlet("/updateEventServlet")
public class updateEventServlet extends HttpServlet {
    private eventDAO events;

    @Override
    public void init() throws ServletException {
        super.init();
        events = new eventDAOImp(); // Initialize your DAO
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer eventId = (Integer) session.getAttribute("eventId");
        //System.out.println("e_update url" + eventId);

        // Check if eventid parameter is missing or invalid
        if (eventId == null || eventId == 0) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Event ID is missing or invalid.");
            return;
        }

        // Retrieve existing event details
        event existingEvent = null;
        try {
			existingEvent = events.getEventById(eventId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (existingEvent == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Event not found.");
            return;
        }

        // Retrieve parameters from the form submission
        String eventName = req.getParameter("eventname");
        String description = req.getParameter("description");
        String startDate = req.getParameter("start_date");
        String endDate = req.getParameter("end_date");
        String venueName = req.getParameter("venuname");
        String address = req.getParameter("address");
        int totalSeatAvailable = Integer.parseInt(req.getParameter("total_seataval"));
        String eventImg = req.getParameter("event_img");
        double price=(double)Integer.parseInt(req.getParameter("price"));

        // Only update the fields that are provided
        if (eventName != null && !eventName.isEmpty()) {
            existingEvent.setEventname(eventName);
        }
        if (description != null && !description.isEmpty()) {
            existingEvent.setDescription(description);
        }
        if (startDate != null && !startDate.isEmpty()) {
            existingEvent.setStart_date(startDate);
        }
        if (endDate != null && !endDate.isEmpty()) {
            existingEvent.setEnd_date(endDate);
        }
        if (venueName != null && !venueName.isEmpty()) {
            existingEvent.setVenuname(venueName);
        }
        if (address != null && !address.isEmpty()) {
            existingEvent.setAddress(address);
        }
        if (totalSeatAvailable != 0 ) {
            existingEvent.setTotal_seataval(totalSeatAvailable);
        }
        if (eventImg != null && !eventImg.isEmpty()) {
            existingEvent.setEvent_img(eventImg);
        }
        if (price != 0 ) {
            existingEvent.setPrice(price);
        }

        try {
            System.out.println("Inside try of updateEvent Serv");
            events.update(existingEvent);
            resp.sendRedirect("listEvents");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating event.");
        }
    }
}
