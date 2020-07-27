package com.ecommerce.Users;

import java.sql.Connection;

import com.ecommerce.ConnectionFactory;


public class UsersDAO {

	public User getUserByID(int ID) {
		User user = new User();
		
		Connection con = ConnectionFactory.getConnection();
		
		return null;
	}
	
}