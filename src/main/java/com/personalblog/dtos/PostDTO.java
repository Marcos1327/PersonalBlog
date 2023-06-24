package com.personalblog.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class PostDTO {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private CategoryDTO category;
	
	private UserDTO user;
	
	private List<CommentDTO> comment;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<CommentDTO> getComment() {
		return comment;
	}

	public void setComment(List<CommentDTO> comment) {
		this.comment = comment;
	}
	
	

}
