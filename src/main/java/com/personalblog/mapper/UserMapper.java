package com.personalblog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.personalblog.dtos.UserDTO;
import com.personalblog.entities.User;
import com.personalblog.mapper.generic.GenericMapper;

@Mapper
public interface UserMapper extends GenericMapper<User, UserDTO> {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
