package com.pat.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pat.DAO.eventDAO;
import com.pat.DAOImp.eventDAOImp;
import com.pat.modren.event;

@WebServlet("/listEvents")
public class listEventServlet extends HttpServlet {
    private eventDAO events;

    @Override
    public void init(ServletConfig config) {
        events = new eventDAOImp();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<event> eventList = events.getAllEvents();
        req.setAttribute("events", eventList);
        req.getRequestDispatcher("welcome.jsp").forward(req, resp);
    }
}
