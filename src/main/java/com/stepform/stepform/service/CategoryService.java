package com.stepform.stepform.service;

import java.util.List;
import java.util.Optional;

import com.stepform.stepform.model.Category;

public interface CategoryService {

	public List<Category> getAllCategories();
	public Optional<Category> getCategoryById(int id);
	public Category getCategoryByTitle(String title);
}
