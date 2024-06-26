package com.pat.DAO;

import java.util.List;

import com.pat.modren.bookings;

public interface bookingDAO {
	 void save(bookings booking);
	    bookings getBookingById(int bookingid);
	     List<bookings> getAllBookings();
	    void update(bookings booking);
	    void delete(int bookingid);
	    List<bookings> getBookingsByEventId(int eventid);
	    bookings getBookingByIds(int eventid, int userid);
}
