package com.stepform.stepform.controller;

import java.security.SecureRandom;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
		user.setEmail(user.getEmail().toLowerCase());


		bCrypt = new BCryptPasswordEncoder(WORKFACTOR, new SecureRandom());
		String encodedPassword = bCrypt.encode(user.getPass());

		user.setPass(encodedPassword);
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not UNIQUE email\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Register successful\n");
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
				return ResponseEntity.status(HttpStatus.OK).body("Login successful\n");
			}

		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect credentials\n");

	}

}
