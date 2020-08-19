package com.ecommerce.Users;

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

@RestController
public class UserContoller {
	UsersDAO dao = new UsersDAO();


	@GetMapping("user/{id}")
	public User getUser(@PathVariable int id) {
		User user = new User();
		user = dao.GetUserByID(id);
		if (user != null)
			return user;
		else
			return null;
	}
	
	@PostMapping("user")
	public String newUser(@RequestBody User user) {
		if (user.getEmail() == null)
			return "request did not contain email";
		if (user.getUsername() == null)
			return "request did not contain username";
		if (user.getPassword() == null)
			return "request did not contain password";
		return String.valueOf(dao.CreateUser(user));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("")
	public String test() {
		return "hello";
	}
	
}
