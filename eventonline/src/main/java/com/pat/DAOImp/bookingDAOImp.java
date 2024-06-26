package com.pat.DAOImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pat.DAO.bookingDAO;
import com.pat.modren.bookings;

public class bookingDAOImp implements bookingDAO {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/e_book";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_BOOKING_SQL = "INSERT INTO booking (e_eventid, u_userid, uname, uemail, phone_number, number_ticketaval, totalprice, booking_date, payment_mode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOKING_BY_ID = "SELECT * FROM booking WHERE bookingid = ?";
    private static final String SELECT_ALL_BOOKINGS = "SELECT * FROM booking";
    private static final String UPDATE_BOOKING_SQL = "UPDATE booking SET e_eventid = ?, u_userid = ?, uname = ?, uemail = ?, phone_number = ?, number_ticketaval = ?, totalprice = ?, booking_date = ?, payment_mode = ? WHERE bookingid = ?";
    private static final String DELETE_BOOKING_SQL = "DELETE FROM booking WHERE bookingid = ?";

    @Override
    public void save(bookings booking) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(INSERT_BOOKING_SQL)) {
                stmt.setInt(1, booking.getE_eventid());
                stmt.setInt(2, booking.getU_userid());
                stmt.setString(3, booking.getUname());
                stmt.setString(4, booking.getUemail());
                stmt.setLong(5, booking.getPhone_number());
                stmt.setLong(6, booking.getNumber_ticketaval());
                stmt.setDouble(7, booking.getTotalprice());
                stmt.setString(8, booking.getBooking_date());
                stmt.setString(9, booking.getPayment_mode());
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("good");
                }else {
                	System.out.println("Bad");
                }
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public bookings getBookingById(int bookingid) {
        bookings booking = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(SELECT_BOOKING_BY_ID)) {
                stmt.setInt(1, bookingid);
                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next()) {
                        booking = new bookings();
                        booking.setBookingid(resultSet.getInt("bookingid"));
                        booking.setE_eventid(resultSet.getInt("e_eventid"));
                        booking.setU_userid(resultSet.getInt("u_userid"));
                        booking.setUname(resultSet.getString("uname"));
                        booking.setUemail(resultSet.getString("uemail"));
                        booking.setPhone_number(resultSet.getLong("phone_number"));
                        booking.setNumber_ticketaval(resultSet.getLong("number_ticketaval"));
                        booking.setTotalprice(resultSet.getDouble("totalprice"));
                        booking.setBooking_date(resultSet.getString("booking_date"));
                        booking.setPayment_mode(resultSet.getString("payment_mode"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public List<bookings> getAllBookings() {
        List<bookings> bookings = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BOOKINGS);
                 ResultSet resultSet = stmt.executeQuery()) {

                while (resultSet.next()) {
                    bookings booking = new bookings();
                    booking.setBookingid(resultSet.getInt("bookingid"));
                    booking.setE_eventid(resultSet.getInt("e_eventid"));
                    booking.setU_userid(resultSet.getInt("u_userid"));
                    booking.setUname(resultSet.getString("uname"));
                    booking.setUemail(resultSet.getString("uemail"));
                    booking.setPhone_number(resultSet.getLong("phone_number"));
                    booking.setNumber_ticketaval(resultSet.getLong("number_ticketaval"));
                    booking.setTotalprice(resultSet.getDouble("totalprice"));
                    booking.setBooking_date(resultSet.getString("booking_date"));
                    booking.setPayment_mode(resultSet.getString("payment_mode"));
                    bookings.add(booking);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public void update(bookings booking) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(UPDATE_BOOKING_SQL)) {
                stmt.setInt(1, booking.getE_eventid());
                stmt.setInt(2, booking.getU_userid());
                stmt.setString(3, booking.getUname());
                stmt.setString(4, booking.getUemail());
                stmt.setLong(5, booking.getPhone_number());
                stmt.setLong(6, booking.getNumber_ticketaval());
                stmt.setDouble(7, booking.getTotalprice());
                stmt.setString(8, booking.getBooking_date());
                stmt.setString(9, booking.getPayment_mode());
                stmt.setInt(10, booking.getBookingid());
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("good");
                }else {
                	System.out.println("Bad");
                }
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void delete(int bookingid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(DELETE_BOOKING_SQL)) {
                stmt.setInt(1, bookingid);
                int i = stmt.executeUpdate();
                if(i>0) {
                	System.out.println("good");
                }else {
                	System.out.println("Bad");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
        
        
    }

	@Override
	public List<bookings> getBookingsByEventId(int eventid) {
		List<bookings> bookingsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
            String sql = "SELECT * FROM booking WHERE e_eventid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eventid);
            rs = stmt.executeQuery();

            while (rs.next()) {
                bookings booking = new bookings();
                // Set booking properties from ResultSet
                booking.setBookingid(rs.getInt("bookingid"));
                booking.setUname(rs.getString("uname"));
                booking.setUemail(rs.getString("uemail"));
                booking.setPhone_number(rs.getLong("phone_number"));
                booking.setNumber_ticketaval(rs.getLong("number_ticketaval"));
                booking.setTotalprice(rs.getDouble("totalprice"));
                booking.setBooking_date(rs.getString("booking_date"));
                booking.setPayment_mode(rs.getString("payment_mode"));

                bookingsList.add(booking);
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return bookingsList;
    }

	@Override
	public bookings getBookingByIds(int eventid, int userid) {
		 
		        Connection conn = null;
		        PreparedStatement stmt = null;
		        ResultSet rs = null;
		        bookings bookingDetails = null;

		        try {
		            conn =   DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);// Replace with your database connection method

		            String sql = "SELECT * FROM booking WHERE e_eventid = ? AND u_userid = ?";
		            stmt = conn.prepareStatement(sql);
		            stmt.setInt(1, eventid);
		            stmt.setInt(2, userid);
		            rs = stmt.executeQuery();

		            if (rs.next()) {
		                bookingDetails = new bookings();
		                bookingDetails.setBookingid(rs.getInt("bookingid"));
		                bookingDetails.setE_eventid(rs.getInt("e_eventid"));
		                bookingDetails.setU_userid(rs.getInt("u_userid"));
		                bookingDetails.setUname(rs.getString("uname"));
		                bookingDetails.setUemail(rs.getString("uemail"));
		                bookingDetails.setPhone_number(rs.getLong("phone_number"));
		                bookingDetails.setNumber_ticketaval(rs.getLong("number_ticketaval"));
		                bookingDetails.setTotalprice(rs.getDouble("totalprice"));
		                bookingDetails.setBooking_date(rs.getString("booking_date"));
		                bookingDetails.setPayment_mode(rs.getString("payment_mode"));
		            }

		        } catch (SQLException e) {
		            e.printStackTrace(); // Hand
	}
		        return bookingDetails;
	}
}


