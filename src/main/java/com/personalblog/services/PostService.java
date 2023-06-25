package com.personalblog.services;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.PostDTO;
import com.personalblog.entities.Post;
import com.personalblog.handlers.ObjectNotFoundHandler;
import com.personalblog.repositories.PostRespository;

import jakarta.transaction.Transactional;

@Service
public class PostService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PostRespository postRespository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@Transactional
	public Post create(PostDTO postDTO) {
		var postModel = new Post();
		var category = categoryService.getById(postDTO.getCategory().getId());
		var userModel = userService.getUserById(postDTO.getUser().getId());
				
		postModel.setId(null);
		postModel.setCreateDate(LocalDateTime.now());
		postModel.setModifiedDate(LocalDateTime.now());
		postModel.setUser(userModel);
		postModel.setCategory(category);
		BeanUtils.copyProperties(postDTO, postModel);
		
		return postRespository.save(postModel);
	}

	public Post getById(long postId) {
		return postRespository.findById(postId).orElseThrow(() -> new ObjectNotFoundHandler("Id not found " + postId));
	}
	
	public List<Post> getAllByUserId(long userId) {
		
		var user = userService.getUserById(userId);
		
		return user.getPosts();
	}

	@Transactional
	public Post update(long postId, PostDTO postDTO) {
		Optional<Post> optionalPost = postRespository.findById(postId);
		
		Post post = optionalPost.orElseThrow(() -> new ObjectNotFoundHandler("PostId not found " + postId));
		post.setModifiedDate(LocalDateTime.now());
		BeanUtils.copyProperties(postDTO, post);
		
		return postRespository.save(post);
	}

	@Transactional
	public void delete(long postId) {
		postRespository.deleteById(postId);
	}
	
}
