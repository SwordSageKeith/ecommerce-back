package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://database-18.cgsyjtny2rf9.us-east-2.rds.amazonaws.com:3306/empdb";
    public static final String USER = "admin";
    public static final String PASS = "admin123";

    public static Connection getConnection() {
    	try {
    		DriverManager.registerDriver(new Driver());
    		return DriverManager.getConnection(URL, USER, PASS);
    	} catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    
}
