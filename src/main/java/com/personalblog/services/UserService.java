package com.personalblog.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.dtos.UserDTO;
import com.personalblog.entities.User;
import com.personalblog.handlers.ObjectNotFoundHandler;
import com.personalblog.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User createUser(UserDTO userDTO) {
		var user = new User();
		user.setId(null);
		user.setCreateDate(LocalDateTime.now());
		BeanUtils.copyProperties(userDTO, user);
		return userRepository.save(user);
	}
	
	public User getUserById(long userId) {
		var user = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundHandler("User not found " + userId));
		return user;
	}
	
	public List<User> getAllUsers() {
		
		var user = userRepository.findAll();
		return user;
	}
	
	@Transactional
	public User updateUser(long userId, UserDTO userDTO) {
		Optional<User> optionalUser = userRepository.findById(userId);
		
		User user = optionalUser.orElseThrow(() -> new ObjectNotFoundHandler("UserId not found " + userId));
		BeanUtils.copyProperties(userDTO, user);
		
		return userRepository.save(user);
				
	}
	
	
	@Transactional
	public void deleteUser(long userId) {
		 userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundHandler("User not found " + userId));
	     userRepository.deleteById(userId);
	}
}
