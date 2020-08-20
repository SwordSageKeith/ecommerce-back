package com.ecommerce.Users;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		int res = dao.CreateUser(user);
		if (res == 1)
			return "User created succesfully";
		else if (res == 2)
			return "Username is taken";
		else 
			return "Unexpected error creating user";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("")
	public String test() {
		return "hello";
	}
	
}
