package com.personalblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalblog.entities.Comment;
import com.personalblog.entities.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Long countByPost(Post post);

}
