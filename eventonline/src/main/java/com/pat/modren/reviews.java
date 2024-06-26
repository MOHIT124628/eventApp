package com.pat.modren;

public class reviews {
	private int reviewid;
	private int evid;
	private int usid;
	private String u_name;
	private String u_email;
	private int rating;
	private String title;
	private String decsription;
	
	
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public int getEvid() {
		return evid;
	}
	public void setEvid(int evid) {
		this.evid = evid;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecsription() {
		return decsription;
	}
	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}
	public reviews( int evid, int usid, String u_name, String u_email, int rating, String title,
			String decsription) {
		super();
		this.evid = evid;
		this.usid = usid;
		this.u_name = u_name;
		this.u_email = u_email;
		this.rating = rating;
		this.title = title;
		this.decsription = decsription;
	}
	
	public reviews() {
		
	}
	@Override
	public String toString() {
		return "reviews [reviewid=" + reviewid + ", evid=" + evid + ", usid=" + usid + ", u_name=" + u_name
				+ ", u_email=" + u_email + ", rating=" + rating + ", title=" + title + ", decsription=" + decsription
				+ "]";
	}
	
	
}
