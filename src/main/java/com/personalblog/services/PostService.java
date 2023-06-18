package com.personalblog.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.PostDTO;
import com.personalblog.entities.Post;
import com.personalblog.entities.User;
import com.personalblog.handlers.PostNotFoundException;
import com.personalblog.handlers.UserNotFoundException;
import com.personalblog.mapper.PostMapper;
import com.personalblog.mapper.UserMapper;
import com.personalblog.repositories.PostRespository;
import com.personalblog.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	
	@Autowired
	private PostRespository postRespository;
	
	@Autowired
	private UserRepository userRespository;
	
	@Transactional
	public Post create(PostDTO postDTO) {
		var postModel = new Post();
		var userModel = new User();
		
		long user = postDTO.getUser().getId();
		userModel = userRespository.findById(user).orElseThrow(() -> new UserNotFoundException("User not found"));
		
		postModel.setId(null);
		postModel.setCreateDate(LocalDateTime.now());
		postModel.setModifiedDate(LocalDateTime.now());
		postModel.setUser(userModel);
		BeanUtils.copyProperties(postDTO, postModel);
		return postRespository.save(postModel);
	}
	
	public Post getById(long postId) {
		return postRespository.findById(postId).orElseThrow(() -> new PostNotFoundException("Id not found"));
	}
	
	@Transactional
	public Post update(long postId, PostDTO postDTO) {
		Optional<Post> post0 = postRespository.findById(postId);
		
		if(post0.isEmpty()) {
			throw new PostNotFoundException("Id not found");
		}
		var post = post0.get();
		post.setModifiedDate(LocalDateTime.now());
		BeanUtils.copyProperties(postDTO, post);
		return postRespository.save(post);
	}
	
	@Transactional
	public void delete(long postId) {
		postRespository.findById(postId).orElseThrow(() -> new PostNotFoundException("Id not found"));
		postRespository.deleteById(postId);
	}
	
	

}
