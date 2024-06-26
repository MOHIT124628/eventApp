package com.pat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.reviewsDAO;
import com.pat.DAOImp.reviewsDAOImp;
import com.pat.modren.reviews;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Retrieve event ID and user ID from request parameters
        Integer eventid = Integer.parseInt(request.getParameter("eventid"));
        Integer userid = Integer.parseInt(request.getParameter("userid"));

        // Get the review details from the request
        String u_name = (String) session.getAttribute("username");
        String u_email = (String) session.getAttribute("useremail");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Create a review object
        reviews review = new reviews();
        review.setEvid(eventid);
        review.setUsid(userid);
        review.setU_name(u_name);
        review.setU_email(u_email);
        review.setRating(rating);
        review.setTitle(title);
        review.setDecsription(description);

        // Use ReviewDAO to add the review to the database
        reviewsDAO reviewDAO = new reviewsDAOImp();
        reviewDAO.save(review);

        // Redirect back to the event details page with eventid
        response.sendRedirect("e_viewevent.jsp?eventid=" + eventid);
    }
}
