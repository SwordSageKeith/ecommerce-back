package com.ecommerce.items;


import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Users.User;
import com.ecommerce.Users.UsersDAO;

@RestController
public class ItemController {
	ItemsDAO dao = new ItemsDAO();


	@GetMapping("item/{id}")
	public Item getUser(@PathVariable int id) {
		Item item = new Item();
		item = dao.GetItemByID(id);
		if (item != null)
			return item;
		else
			return null;
	}
	
	@GetMapping("items")
	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items = dao.getRecentItems();
		
		return items;
	}
	
	@GetMapping("items/shop/{id}")
	public ArrayList<Item> getShopItems(@PathVariable int id) {
		ArrayList<Item> items = new ArrayList<Item>();
		items = dao.getShopItems(id);
		
		return items;
	}
	
	@PostMapping("item")
	public String newUser(@RequestBody Item item) {
		if (item.getName() == null) 
			return "request did not contain name";
		if (item.getShopID() == 0)
			return "request did not contain a shop ID";
		int res = dao.CreateItem(item);
		if (res == 1)
			return "Item created successfuly";
		else 
			return "Unexpected error creating item";
	}
	
}
