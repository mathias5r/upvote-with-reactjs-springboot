package com.upvote.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.upvote.model.Post;
import com.upvote.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {

	private final String author = "Mathias"; 
	private final String text = "Test";
	
	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Autowired
	private PostRepository postRepository;
	
	private Post post;
	
	@Before
	public void setUp() throws Exception{
		//arrange
		this.post = new Post();
		this.post.setAuthor(author);
		this.post.setDate(new Date().toString());
		this.post.setText(new StringBuffer(text));
		postRepository.save(this.post);
	}
	
	@After
	public void end() throws Exception{
		//end
		postRepository.delete(this.post);
	}
	
	@Test
	public void testCreateAction() throws Exception{
		//act
		HttpEntity<Post> request = new HttpEntity<>(new Post());
		ResponseEntity<Post> response = restTemplate.postForEntity("/post?author={author}&text={text}", request, Post.class, author, text);
		Post postTest = response.getBody();
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(postTest).isNotNull();
		assertThat(postTest.getAuthor().toString()).isEqualTo(author);
		assertThat(postTest.getText().toString()).isEqualTo(text);
	}
	
	@Test
	public void testGetPostAction() throws Exception{
		//act
		ResponseEntity<Post> response = restTemplate.getForEntity("/post?id={id}", Post.class, post.getID());
		Post postTest = response.getBody();
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(postTest).isNotNull();
		assertThat(postTest.getID()).isEqualTo(post.getID());
		assertThat(postTest.getAuthor().toString()).isEqualTo(author);
		assertThat(postTest.getDate()).isEqualTo(post.getDate());
		assertThat(postTest.getText().toString()).isEqualTo(text);
		assertThat(postTest.getUpvotes()).isEqualTo(post.getUpvotes());
	}
	
	@Test
	public void testGetAllAction() throws Exception{
		//act
		ResponseEntity<List<Post>> response = restTemplate.exchange("/posts", 
				HttpMethod.GET, null,  new ParameterizedTypeReference<List<Post>>() {
        });
		List<Post> posts = response.getBody();

		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(posts).isNotNull();
		assertThat(posts).isNotEmpty();
		assertThat(posts).contains(this.post);
	}
	
	@Test
	public void testUpvoteAction() throws Exception{
		//act
		HttpEntity<Post> request = new HttpEntity<>(new Post());
		ResponseEntity<Post> response = restTemplate.postForEntity("/upvote?id={id}", request, Post.class, post.getID());
		Post postTest = response.getBody();
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(postTest).isNotNull();
		assertThat(postTest.getID()).isEqualTo(post.getID());
		assertThat(postTest.getUpvotes()).isGreaterThan(0);	
	}
	
}
