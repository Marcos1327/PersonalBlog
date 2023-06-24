package com.personalblog.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {
	
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
