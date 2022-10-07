package com.stepform.stepform.controller;

import java.security.SecureRandom;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	private final int WORKFACTOR = 10; //work factor of bcrypt
	private final String UK_EMAIL = "UK_ob8kqyqqgmefl0aco34akdtpe";
	private final String UK_USERNAME = "UK_lqjrcobrh9jc8wpcar64q1bfh";
	private final String ERROR_EMAIL = "The email is already in use";
	private final String ERROR_USERNAME = "The username is already in use";

	private BCryptPasswordEncoder bCrypt;

	@Autowired
	private UserService userService;

	// TEST
	@GetMapping(path = "/getall")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		JSONObject entity = new JSONObject(); 
		
		user.setEmail(user.getEmail().toLowerCase());

		bCrypt = new BCryptPasswordEncoder(WORKFACTOR, new SecureRandom());

		String encodedPassword = bCrypt.encode(user.getPass());
		user.setPass(encodedPassword);

		try {
			userService.saveUser(user);
		} catch (Exception e) {
			

			System.err.println(e.getMessage());
			if(e.getMessage().contains(UK_USERNAME)) {
				entity.put("username", ERROR_USERNAME);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(entity.toString());
			} else if(e.getMessage().contains(UK_EMAIL)){
				entity.put("email", ERROR_EMAIL);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(entity.toString());
			}		
		}
		
		entity.put("id_user", user.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(entity.toString());
	}

	@PostMapping("/login")
	public ResponseEntity<String> checkUser(@RequestBody User user) {
		// TO-DO
		String email = user.getEmail().toLowerCase();
		String pass = user.getPass();

		User userLoaded = userService.loadUserByEmail(email);


		if(userLoaded != null) {

			String emailDb = userLoaded.getEmail();
			String passDb = userLoaded.getPass();

			// TODO hash-pass
			bCrypt = new BCryptPasswordEncoder();
			boolean passChecker = bCrypt.matches(pass, passDb);

			if(email.equals(emailDb) && passChecker) {
				
				JSONObject entity = new JSONObject(); 
				entity.put("id_user", userLoaded.getId());
				return ResponseEntity.status(HttpStatus.OK).body(entity.toString());
			}

		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect credentials\n");

	}

}
