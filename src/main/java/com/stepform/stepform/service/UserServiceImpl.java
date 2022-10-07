package com.stepform.stepform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepform.stepform.model.User;
import com.stepform.stepform.repository.UserRepository;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User loadUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	@Override
	public Optional<User> getUserById(int id) {
		
		return userRepository.findById(id);
	}


}
