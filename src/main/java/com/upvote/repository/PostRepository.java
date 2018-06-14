package com.upvote.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.upvote.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>, JpaSpecificationExecutor<Post>{

	Optional<Post> findByAuthor(String author);
	
}
