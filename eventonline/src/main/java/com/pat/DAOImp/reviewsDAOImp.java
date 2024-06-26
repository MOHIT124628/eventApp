package com.pat.DAOImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pat.DAO.reviewsDAO;
import com.pat.modren.reviews;

public class reviewsDAOImp implements reviewsDAO {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/e_book";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_REVIEW_SQL = "INSERT INTO reviews (evid, usid, u_name, u_email, rating, title, decsription) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_REVIEW_BY_ID = "SELECT * FROM reviews WHERE reviewid = ?";
    private static final String SELECT_ALL_REVIEWS = "SELECT * FROM reviews";
    private static final String UPDATE_REVIEW_SQL = "UPDATE reviews SET evid = ?, usid = ?, u_name = ?, u_email = ?, rating = ?, title = ?, decsription = ? WHERE reviewid = ?";
    private static final String DELETE_REVIEW_SQL = "DELETE FROM reviews WHERE reviewid = ?";

    @Override
    public void save(reviews review) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(INSERT_REVIEW_SQL)) {
                stmt.setInt(1, review.getEvid());
                stmt.setInt(2, review.getUsid());
                stmt.setString(3, review.getU_name());
                stmt.setString(4, review.getU_email());
                stmt.setInt(5, review.getRating());
                stmt.setString(6, review.getTitle());
                stmt.setString(7, review.getDecsription());
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("Good");
                }else {
                	System.out.println("Bad");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public reviews getReviewById(int reviewid) {
        reviews review = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(SELECT_REVIEW_BY_ID)) {
                stmt.setInt(1, reviewid);
                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next()) {
                        review = new reviews();
                        review.setReviewid(resultSet.getInt("reviewid"));
                        review.setEvid(resultSet.getInt("evid"));
                        review.setUsid(resultSet.getInt("usid"));
                        review.setU_name(resultSet.getString("u_name"));
                        review.setU_email(resultSet.getString("u_email"));
                        review.setRating(resultSet.getInt("rating"));
                        review.setTitle(resultSet.getString("title"));
                        review.setDecsription(resultSet.getString("decsription"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public List<reviews> getAllReviews() {
        List<reviews> reviews = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(SELECT_ALL_REVIEWS);
                 ResultSet resultSet = stmt.executeQuery()) {

                while (resultSet.next()) {
                    reviews review = new reviews();
                    review.setReviewid(resultSet.getInt("reviewid"));
                    review.setEvid(resultSet.getInt("evid"));
                    review.setUsid(resultSet.getInt("usid"));
                    review.setU_name(resultSet.getString("u_name"));
                    review.setU_email(resultSet.getString("u_email"));
                    review.setRating(resultSet.getInt("rating"));
                    review.setTitle(resultSet.getString("title"));
                    review.setDecsription(resultSet.getString("decsription"));
                    reviews.add(review);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void update(reviews review) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(UPDATE_REVIEW_SQL)) {
                stmt.setInt(1, review.getEvid());
                stmt.setInt(2, review.getUsid());
                stmt.setString(3, review.getU_name());
                stmt.setString(4, review.getU_email());
                stmt.setInt(5, review.getRating());
                stmt.setString(6, review.getTitle());
                stmt.setString(7, review.getDecsription());
                stmt.setInt(8, review.getReviewid());
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("Good");
                }else {
                	System.out.println("Bad");
                }
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void delete(int reviewid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(DELETE_REVIEW_SQL)) {
                stmt.setInt(1, reviewid);
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("Good");
                }else {
                	System.out.println("Bad");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    

    public List<reviews> getReviewsByEventId(int eventId){
    	    List<reviews> reviewsList = new ArrayList<>();
    	    Connection conn = null;
    	    PreparedStatement stmt = null;
    	    ResultSet rs = null;
    	    
    	    try {
    	        conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);// Obtain database connection (using DataSource or DriverManager)
    	        String sql1 = "SELECT u_name, rating, decsription FROM reviews WHERE evid = ?";
    	        stmt = conn.prepareStatement(sql1);
    	        stmt.setInt(1, eventId);
    	        rs = stmt.executeQuery();
    	        
    	        while (rs.next()) {
    	            reviews review = new reviews();
    	            review.setU_name(rs.getString("u_name"));
    	            review.setRating(rs.getInt("rating"));
    	            review.setDecsription(rs.getString("decsription"));
    	            reviewsList.add(review);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	   
    	    } 
    	    
    	    return reviewsList;
    	}


}

