package com.pat.servlet;

import com.pat.DAO.eventDAO;
import com.pat.DAOImp.eventDAOImp;
import com.pat.modren.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        eventDAO eventDao = new eventDAOImp();
        List<event> eventList = eventDao.getAllEvents();

        // Store the event list in the session
        req.getSession(true).setAttribute("events", eventList);
        System.out.println("Events set into session");

        // Forward to the JSP
        req.getRequestDispatcher("welcome.jsp").forward(req, resp);
    }
}
