package com.ecommerce.shops;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
	ShopsDAO dao = new ShopsDAO();
	
	@GetMapping("shop/{id}")
	public Shop getShop(@PathVariable int id) {
		Shop shop = new Shop();
		shop = dao.getShopByID(id);
		if (shop != null)
			return shop;
		else 
			return null;
	}
	
	@PostMapping("shop")
	public String createShop(@RequestBody Shop shop) {
		
		return "aaaa";
	}
}
