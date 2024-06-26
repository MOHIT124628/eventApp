package com.pat.modren;

import java.sql.Date;

public class bookings {
	private int bookingid;
	private int e_eventid;
	private int u_userid;
	private String uname;
	private String uemail;
	private long phone_number;
	private long number_ticketaval;
	private double totalprice;
	private String booking_date;
	private String payment_mode;
	
		
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getE_eventid() {
		return e_eventid;
	}
	public void setE_eventid(int e_eventid) {
		this.e_eventid = e_eventid;
	}
	public int getU_userid() {
		return u_userid;
	}
	public void setU_userid(int u_userid) {
		this.u_userid = u_userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public long getNumber_ticketaval() {
		return number_ticketaval;
	}
	public void setNumber_ticketaval(long number_ticketaval) {
		this.number_ticketaval = number_ticketaval;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public bookings(int bookingid, int e_eventid, int u_userid, String uname, String uemail, long phone_number,
			long number_ticketaval, double totalprice, String booking_date, String payment_mode) {
		super();
		this.bookingid = bookingid;
		this.e_eventid = e_eventid;
		this.u_userid = u_userid;
		this.uname = uname;
		this.uemail = uemail;
		this.phone_number = phone_number;
		this.number_ticketaval = number_ticketaval;
		this.totalprice = totalprice;
		this.booking_date = booking_date;
		this.payment_mode = payment_mode;
	}
	
	public bookings() {
		
	}
	@Override
	public String toString() {
		return "bookings [bookingid=" + bookingid + ", e_eventid=" + e_eventid + ", u_userid=" + u_userid + ", uname="
				+ uname + ", uemail=" + uemail + ", phone_number=" + phone_number + ", number_ticketaval="
				+ number_ticketaval + ", totalprice=" + totalprice + ", booking_date=" + booking_date
				+ ", payment_mode=" + payment_mode + "]";
	}
	
}
