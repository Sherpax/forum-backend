package com.stepform.stepform.service;

import java.util.List;
import java.util.Optional;

import com.stepform.stepform.model.User;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

public interface UserService {

	public User saveUser(User user);
	public List<User> getAllUsers();
	public User loadUserByEmail(String email);
	public Optional<User> getUserById(int id);
	
}
