package com.pat.modren;

public class user {
	private int userid;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone_number;
	private String city;
	private String role;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public user(int userid, String name, String username, String password, String email, String phone_number, String city,
			String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.city = city;
		this.role = role;
	}
	
	public user() {
		
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phone_number=" + phone_number + ", city=" + city + ", role=" + role + "]";
	}

	
}
