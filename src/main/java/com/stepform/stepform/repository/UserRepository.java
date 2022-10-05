package com.stepform.stepform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stepform.stepform.model.User;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

	User findByEmail(String email);

}