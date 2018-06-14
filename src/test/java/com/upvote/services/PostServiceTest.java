package com.upvote.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.upvote.model.Post;
import com.upvote.repository.PostRepository;
import com.upvote.service.PostService;
import com.upvote.service.impl.PostServiceImpl;

@RunWith(SpringRunner.class)
public class PostServiceTest {
		
	private static final String name = "Mathias";
	private static final String text = "New post!";
	
	@MockBean
	private PostRepository postRepository;
	
	private PostService postService;
	
	private Post post;
	
	@Before
	public void setUp() throws Exception {
				
		postService = new PostServiceImpl(postRepository);
		
		post = new Post();
		post.setAuthor(name);
		post.setDate(new Date().toString());
		post.setText(new StringBuffer(text));
		
		when(postRepository.findById(post.getID())).thenReturn(Optional.empty());
		when(postRepository.findByAuthor(post.getAuthor())).thenReturn(Optional.empty());
	}
	
	@After
	public void onFinish() {
		postRepository.delete(post);
	}
	
	@Test
	public void mustCreatePost() throws Exception {
		postService.savePost(post);
		verify(postRepository).save(post);
	}
		
	@Test
	public void mustFindByAuthor() throws Exception{
		when(postRepository.findByAuthor(post.getAuthor())).thenReturn(Optional.of(post));
		Post postTest = postService.findByAuthor(post.getAuthor());
		verify(postRepository).findByAuthor(name);
		assertThat(postTest).isNotNull();
		assertThat(postTest.getAuthor()).isEqualTo(name);
	}
	
	@Test
	public void mustFindById() throws Exception{
		when(postRepository.findById(post.getID())).thenReturn(Optional.of(post));
		Post postTest = postService.findById(post.getID());
		verify(postRepository).findById(post.getID());
		assertThat(postTest).isNotNull();
		assertThat(postTest.getID()).isEqualTo(post.getID());
	}
	
	@Test
	public void mustUpvote() throws Exception{
		when(postRepository.findById(post.getID())).thenReturn(Optional.of(post));
		long postUpvotes = post.getUpvotes();
		Post postTest = postService.findById(post.getID());
		verify(postRepository).findById(post.getID());
		long postTestUpvotes = postTest.getUpvotes();
		postTest.setUpvotes(postTestUpvotes + 1);
		assertThat(postTest).isNotNull();
		assertThat(postTest.getUpvotes()).isGreaterThan(postUpvotes);
	}
			
}
