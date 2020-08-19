package com.ecommerce.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerce.ConnectionFactory;


public class UsersDAO {

	public String UpdateUser(int ID, User user) {
		
		
		return "User updated succesfully";
	}
	
	public User GetUserByID(int ID) {
		User user = new User();
		
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userID = " + ID);
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setID(rs.getInt("userID"));
				user.setPassword("lol you thought");
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 0 is an unexpected failure
	 * 1 is a success
	 * 2 is a taken username
	 * */
	public int CreateUser(User user) {
		if (CheckForUser(user.getUsername())) {
			return 2;
		}
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "INSERT INTO users (username, password, email) VALUES (?,?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				return 1;
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		return 0;
	}
	
	public String DeleteUser(int ID) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = ("DELETE FROM users WHERE userID = " + ID);
			PreparedStatement stmt = con.prepareStatement(sql);
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				return "User deleted successfully";
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "user failed to be deleted";
	}
	
	public Boolean CheckForUser(String name) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE username = ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.absolute(1)) {
				return true;
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		
		return false;
	}
}