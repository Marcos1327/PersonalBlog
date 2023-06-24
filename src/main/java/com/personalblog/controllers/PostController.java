package com.personalblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalblog.dtos.PostDTO;
import com.personalblog.entities.Post;
import com.personalblog.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody @Valid PostDTO postDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(postDTO));
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Post> getById(@PathVariable long postId) {
		return ResponseEntity.ok(postService.getById(postId));
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<Post> update(@PathVariable long postId, @RequestBody @Valid PostDTO postDTO) {
		return ResponseEntity.ok(postService.update(postId, postDTO));
	}
	
	@DeleteMapping("{postId}")
	public ResponseEntity<Void> delete(@PathVariable long postId) {
		postService.delete(postId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{userId}/posts")
	public ResponseEntity<List<Post>> getPosts(@PathVariable long userId) {
		return ResponseEntity.ok(postService.getAllByUserId(userId));
	}
}
