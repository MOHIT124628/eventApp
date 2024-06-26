package com.pat.modren;

import java.sql.Date;

public class event {
	private int eventid;
	private String eventname;
	private String description;
	private String start_date;
	private String end_date;
	private String venuname;
	private String address;
	private int total_seataval;
	private String event_img;
	private double price;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getVenuname() {
		return venuname;
	}
	public void setVenuname(String venuname) {
		this.venuname = venuname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotal_seataval() {
		return total_seataval;
	}
	public void setTotal_seataval(int total_seataval) {
		this.total_seataval = total_seataval;
	}
	public String getEvent_img() {
		return event_img;
	}
	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}
	public event(int eventid, String eventname, String description, String start_date, String end_date, String venuname,
			String address, int total_seataval, String event_img,int price) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.venuname = venuname;
		this.address = address;
		this.total_seataval = total_seataval;
		this.event_img = event_img;
		this.price=price;
	}

	public event() {
		
	}
	@Override
	public String toString() {
		return "event [eventid=" + eventid + ", eventname=" + eventname + ", description=" + description
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", venuname=" + venuname + ", address="
				+ address + ", total_seataval=" + total_seataval + ", event_img=" + event_img + ", price=" + price+"]";
	}
		
}
