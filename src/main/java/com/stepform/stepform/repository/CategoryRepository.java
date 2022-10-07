package com.stepform.stepform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepform.stepform.model.Category;


	@Repository
	public interface CategoryRepository  extends JpaRepository<Category, Integer>{
		
		Category findByTitle(String title);
	}

