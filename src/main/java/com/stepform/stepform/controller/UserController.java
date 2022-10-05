package com.stepform.stepform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepform.stepform.model.User;
import com.stepform.stepform.service.UserService;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	// TEST
	@GetMapping(path = "/getall")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/register")
	public String addUser(@RequestBody User user) {
		user.setEmail(user.getEmail().toLowerCase());
		userService.saveUser(user);
		return "New user have been registered";
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public String checkUser(@RequestBody User user) {
		// TO-DO
		String email = user.getEmail().toLowerCase();
		String pass = user.getPass();
		
		User userLoaded = userService.loadUserByEmail(email);
		
		if(userLoaded != null) {
			
			String emailDb = userLoaded.getEmail();
			String passDb = userLoaded.getPass();
			
			// TODO hash-pass
			
			if(email.equals(emailDb) && pass.equals(passDb)) {
				return "OK";
			}
			
		}

		return "KO";
		
	}
	
}
