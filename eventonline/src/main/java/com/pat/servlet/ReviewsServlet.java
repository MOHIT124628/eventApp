package com.pat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pat.DAO.*;
import com.pat.DAOImp.*;
import com.pat.modren.*;
import java.util.*;

@WebServlet("/ReviewsServlet")
	public class ReviewsServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve eventid from request parameter
	        int eventid = Integer.parseInt(request.getParameter("eventid"));

	        // Retrieve reviews for the eventid from DAO
	        reviewsDAO reviewDAO = new reviewsDAOImp();
	        List<reviews> reviewsList = reviewDAO.getReviewsByEventId(eventid);

	        // Forward reviewsList to JSP for display
	        request.setAttribute("reviewsList", reviewsList);
	        request.getRequestDispatcher("reviews.jsp").forward(request, response);
	    }
	}


