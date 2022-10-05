package com.stepform.stepform.service;

import java.util.List;

import com.stepform.stepform.model.User;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

public interface UserService {

	public User saveUser(User user);
	public List<User> getAllUsers();
	public User loadUserByEmail(String email);
	
}
