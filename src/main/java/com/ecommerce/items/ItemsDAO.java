package com.ecommerce.items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecommerce.ConnectionFactory;

public class ItemsDAO {

	// search for items
	// update item
	// delete item
	//hide / unhide item
	
	public Item GetItemByID(int ID) {
		Item item = new Item();
		
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM items WHERE userID = " + ID);
			if (rs.next()) {
				item.setName(rs.getString("name"));
				item.setDesc(rs.getString("desc"));
				item.setID(rs.getInt("itemID"));
				item.setShopID(rs.getInt("shopID"));
				item.setPrice(rs.getFloat("price"));
				item.setHidden(rs.getBoolean("hidden"));
				return item;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Item> getRecentItems() {
		Item item = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT * FROM items ORDER BY id DESC LIMIT 30";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item.setName(rs.getString("name"));
				item.setDesc(rs.getString("desc"));
				item.setID(rs.getInt("itemID"));
				item.setShopID(rs.getInt("shopID"));
				item.setPrice(rs.getFloat("price"));
				item.setHidden(rs.getBoolean("hidden"));
				
				items.add(item);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return items;
	}
	
	public ArrayList<Item> getShopItems(int id) {
		Item item = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT * FROM items WHERE shopID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item.setName(rs.getString("name"));
				item.setDesc(rs.getString("desc"));
				item.setID(rs.getInt("itemID"));
				item.setShopID(rs.getInt("shopID"));
				item.setPrice(rs.getFloat("price"));
				item.setHidden(rs.getBoolean("hidden"));
				
				items.add(item);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return items;
	}
	
	public int CreateItem(Item item) {
		Connection con = ConnectionFactory.getConnection();
		
		try {
			String sql = "INSERT INTO items (name, shopID, price, desc, hidden) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setInt(2, item.getShopID());
			stmt.setFloat(3, item.getPrice());
			stmt.setString(4, item.getDesc());
			stmt.setBoolean(5, item.getHidden());
			
			int result = stmt.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return 0;
	}
}
