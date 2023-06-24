package com.personalblog.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.CommentDTO;
import com.personalblog.entities.Comment;
import com.personalblog.handlers.BussinesNotFoundException;
import com.personalblog.repositories.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public Comment create(long postId,  CommentDTO commentDTO) {
		var postModel = postService.getById(postId);
		var userModel = userService.getUserById(commentDTO.getUser().getId());
		
		var comment = new Comment();
		
		comment.setId(null);
		comment.setCreateDate(LocalDateTime.now());
		comment.setModifiedDate(LocalDateTime.now());
		comment.setPost(postModel);
		comment.setUser(userModel);
		
		BeanUtils.copyProperties(commentDTO, comment);
		
		return commentRepository.save(comment);
	}
	
	@Transactional
	public Comment update(CommentDTO commentDTO) {
		Optional<Comment> comment0 = commentRepository.findById(commentDTO.getId());
		
		if (comment0.isEmpty()) {
			throw new BussinesNotFoundException("CommentId not Found ");
		}
		var comment = new Comment();
		
		comment = comment0.get();
		comment.setModifiedDate(LocalDateTime.now());
		BeanUtils.copyProperties(commentDTO, comment);
		
		return commentRepository.save(comment);
	}
	
	@Transactional
	public void delete(long commentId) {
		commentRepository.findById(commentId).orElseThrow(() -> new BussinesNotFoundException("CommentId not found " + commentId));
		commentRepository.deleteById(commentId);
	}
	
	public Comment getById(long commentId) {
		return commentRepository.findById(commentId).orElseThrow(() -> new BussinesNotFoundException("Id not found " + commentId));
	}

}
