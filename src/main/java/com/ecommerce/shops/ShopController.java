package com.ecommerce.shops;

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
		if (shop.getName() == null)
			return "request does not contain a name";
		if (shop.getOwner() == -1)
			return "request does not contain a owner";
		Shop check = dao.getShopByID(shop.getOwner());
		if (check == null)
			return "Specified owner does not exist";
		
		if (dao.userHasShop(shop.getOwner()))
			return "User already has a shop";
		
		Boolean ret = dao.createShop(shop);
		if (ret)
			return "Shop created successfuly";
		else {
			return "Shop failed to create";
		}
	}
}
