package com.ecommerce.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerce.ConnectionFactory;


public class UsersDAO {

	//  Update user function
	
	public User getUserByID(int ID) {
		User user = new User();
		
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userID = " + ID);
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				con.close();
				stmt.close();
				rs.close();
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Boolean CreateUser(User user) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "INSERT INTO users (username, password, email) VALUES (?,?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			
			int rowsInserted = stmt.executeUpdate();
			con.close();
			stmt.close();
			if (rowsInserted > 0) {
				return true;
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		return false;
	}
	
	public Boolean DeleteUser(int ID) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = ("DELETE FROM users WHERE userID = " + ID);
			PreparedStatement stmt = con.prepareStatement(sql);
			int result = stmt.executeUpdate(sql);
			con.close();
			stmt.close();
			if (result > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}