package com.personalblog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.UserDTO;
import com.personalblog.entities.User;
import com.personalblog.handlers.UserNotFoundException;
import com.personalblog.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User createUser(UserDTO userDTO) {
		var user = new User();
		user.setId(null);
		user.setCreateDate(LocalDateTime.now());
		BeanUtils.copyProperties(userDTO, user);
		return userRepository.save(user);
	}
	
	public User getUserById(long userId) {
		var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		
		return user;
	}
	
	public List<User> getAllUsers(){
		var user = userRepository.findAll();
		
		return user;
	}

}
