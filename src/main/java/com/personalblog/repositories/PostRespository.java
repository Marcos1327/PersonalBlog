package com.personalblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalblog.entities.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Long> {

}
