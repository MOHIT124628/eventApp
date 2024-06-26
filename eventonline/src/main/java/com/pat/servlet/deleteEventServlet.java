package com.pat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pat.DAO.eventDAO;
import com.pat.DAOImp.eventDAOImp;

@WebServlet("/deleteEventServlet")
public class deleteEventServlet extends HttpServlet {
    private eventDAO events;

    @Override
    public void init() throws ServletException {
        super.init();
        events = new eventDAOImp(); // Initialize your DAO
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int eventIdStr = Integer.parseInt(req.getParameter("eventid"));
        
        if (eventIdStr ==0) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Event ID is missing.");
            return;
        }

        int eventId = eventIdStr;

        
        events.delete(eventId);

        
        resp.sendRedirect("listEvents"); 
    }
}


