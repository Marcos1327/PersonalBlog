package com.personalblog.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	private LocalDate createDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	

}
