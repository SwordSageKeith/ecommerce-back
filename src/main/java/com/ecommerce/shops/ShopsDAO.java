package com.ecommerce.shops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerce.ConnectionFactory;

public class ShopsDAO {
	
	//  Get shop and items
	//  update shop
	//  get recent shops
	//  search shops
	//  hide shop / unhide shop
	
	public Shop getShopByID(int ID) {
		Shop shop = new Shop();
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shops WHERE shopID = " + ID);
			if (rs.next()) {
				shop.setDesc(rs.getString("desc"));
				shop.setHidden(rs.getBoolean("hidden"));
				shop.setName(rs.getString("name"));
				shop.setOwner(rs.getInt("owner"));
				shop.setShopID(rs.getInt("shopID"));
				return shop;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Boolean deleteShop(int ID) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "DELETE FROM shops WHERE shopID = " + ID;
			PreparedStatement stmt = con.prepareStatement(sql);
			int result = stmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public Boolean createShop(Shop shop) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "INSERT INTO shops (name, owner, desc, hidden) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, shop.getName());
			stmt.setInt(2, shop.getOwner());
			stmt.setString(3, shop.getDesc());
			stmt.setBoolean(4, shop.getHidden());
			
			int inserted = stmt.executeUpdate();
			if (inserted > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public Boolean userHasShop(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shops WHERE owner = " + id);
			if (rs.absolute(1))
				return true;
			else return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
}
