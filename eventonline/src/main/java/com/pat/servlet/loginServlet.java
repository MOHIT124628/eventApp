package com.pat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pat.DAO.userDAO;
import com.pat.DAOImp.userDAOImp;
import com.pat.modren.user;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDAO userDao;

    @Override
    public void init() throws ServletException {
        userDao = new userDAOImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user user1 = userDao.validateUser(email, password);

        if (user1 != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userid", user1.getUserid());
            session.setAttribute("user", user1);
            session.setAttribute("username", user1.getUsername());
            session.setAttribute("useremail", user1.getEmail());

            response.sendRedirect("listEvents"); // Redirect to event listing page after successful login
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
