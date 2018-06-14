package com.upvote.service;

import java.util.List;

import com.upvote.model.Post;
import com.upvote.service.exception.AuthorNotFoundException;
import com.upvote.service.exception.IdNotFoundException;

public interface PostService {

	Post savePost(Post post);

	Post findByAuthor(String author) throws AuthorNotFoundException;

	Post findById(long id) throws IdNotFoundException;

	List<Post> findAll();

}
