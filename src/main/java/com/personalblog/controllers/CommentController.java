package com.personalblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalblog.dtos.CommentDTO;
import com.personalblog.entities.Comment;
import com.personalblog.services.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{postId}")
	public ResponseEntity<Comment> create(@PathVariable long postId, @RequestBody @Valid CommentDTO commentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(postId, commentDTO));
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<Void> deleteById(@PathVariable long commentId) {
		commentService.delete(commentId);
		return ResponseEntity.ok().build();
	}

}
