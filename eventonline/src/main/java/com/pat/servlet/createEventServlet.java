package com.pat.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.eventDAO;
import com.pat.DAOImp.eventDAOImp;
import com.pat.modren.event;

@WebServlet("/createEventServlet")
public class createEventServlet extends HttpServlet {
    private eventDAO events;

    @Override
    public void init(ServletConfig config) {
        events = new eventDAOImp();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventname = req.getParameter("eventname");
        String description = req.getParameter("description");
        String startdate = req.getParameter("start_date");
        String enddate = req.getParameter("end_date");
        String venuname = req.getParameter("venuname");
        String address = req.getParameter("address");
        int totalseat = Integer.parseInt(req.getParameter("total_seataval"));
        String venuimg = req.getParameter("event_img");
        double price = Double.parseDouble(req.getParameter("price"));

        event ev = new event();
        ev.setEventname(eventname);
        ev.setDescription(description);
        ev.setStart_date(startdate);
        ev.setEnd_date(enddate);
        ev.setVenuname(venuname);
        ev.setAddress(address);
        ev.setTotal_seataval(totalseat);
        ev.setEvent_img(venuimg);
        ev.setPrice(price);

        events.save(ev);

        // Store the event in the session
        HttpSession session = req.getSession();
        session.setAttribute("createdEvent", ev);

        resp.sendRedirect("listEvents");
    }
}
