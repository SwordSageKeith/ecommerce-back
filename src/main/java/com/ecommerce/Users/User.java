package com.ecommerce.Users;

public class User {
	
	private String email;
	private String username;
	private String password;
	private int ID;
	
	public User(User user) {
		email = user.email;
		username = user.username;
		password = user.password;
		ID = user.ID;
	}
	
	public User() {
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
