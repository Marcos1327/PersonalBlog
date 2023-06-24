package com.personalblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalblog.dtos.CategoryDTO;
import com.personalblog.entities.Category;
import com.personalblog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok(categoryService.getAll());
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> findById(@PathVariable long categoryId) {
		return ResponseEntity.ok(categoryService.getById(categoryId));
	}
	
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody @Valid CategoryDTO categoryDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(categoryDTO));
	}
	

}
