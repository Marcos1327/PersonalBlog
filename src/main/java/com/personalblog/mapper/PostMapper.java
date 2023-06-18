package com.personalblog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.personalblog.dtos.PostDTO;
import com.personalblog.entities.Post;
import com.personalblog.mapper.generic.GenericMapper;

@Mapper
public interface PostMapper extends GenericMapper<Post, PostDTO>{
	
	PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

}
