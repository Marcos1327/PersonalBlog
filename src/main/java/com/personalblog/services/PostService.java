package com.personalblog.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.PostDTO;
import com.personalblog.entities.Post;
import com.personalblog.repositories.PostRespository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	
	@Autowired
	private PostRespository postRespository;
	
	@Transactional
	public Post create(PostDTO postDTO) {
		var postModel = new Post();
		postModel.setId(null);
		postModel.setCreateDate(LocalDateTime.now());
		BeanUtils.copyProperties(postDTO, postModel);
		return postRespository.save(postModel);
	}
	
	

}
