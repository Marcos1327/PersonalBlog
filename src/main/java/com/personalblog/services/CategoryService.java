package com.personalblog.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.CategoryDTO;
import com.personalblog.entities.Category;
import com.personalblog.handlers.BussinesNotFoundException;
import com.personalblog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	public Category getById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(() -> new BussinesNotFoundException("Category Id not found: " + categoryId));
	}
	
	public Category create(CategoryDTO categoryDTO) {
		var category = new Category();
		
		category.setId(null);
		BeanUtils.copyProperties(categoryDTO, category);
		
		return categoryRepository.save(category);
	}

}
