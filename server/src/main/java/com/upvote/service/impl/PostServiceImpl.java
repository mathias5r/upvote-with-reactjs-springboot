package com.upvote.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upvote.model.Post;
import com.upvote.repository.PostRepository;
import com.upvote.service.PostService;
import com.upvote.service.exception.AuthorNotFoundException;
import com.upvote.service.exception.IdNotFoundException;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post savePost(Post post) {
				
		return postRepository.save(post);
	}

	@Override
	public Post findByAuthor(String author) throws AuthorNotFoundException {
		
		final Optional<Post> optional = postRepository.findByAuthor(author);
				
		return optional.orElseThrow(() -> new AuthorNotFoundException());
	}

	@Override
	public Post findById(long id) throws IdNotFoundException {
		
		final Optional<Post> optional = postRepository.findById(id);
				
		return optional.orElseThrow(() -> new IdNotFoundException());
	}

	@Override
	public List<Post> findAll() {
		
		return postRepository.findAll();
	}
	
}
