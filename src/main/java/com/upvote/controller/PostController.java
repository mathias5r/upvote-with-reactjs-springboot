package com.upvote.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upvote.model.Post;
import com.upvote.service.PostService;
import com.upvote.service.exception.IdNotFoundException;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(path="post", method = RequestMethod.GET)
	public ResponseEntity<Post> getPost(@RequestParam Long id) throws IdNotFoundException {
		Post post = postService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@RequestMapping(path="post", method = RequestMethod.POST)
	public ResponseEntity<Post> addPost(@RequestParam String author, @RequestParam String text) {
		Post post = new Post();
		post.setAuthor(author);
		post.setDate(new Date().toString());
		post.setText(new StringBuffer(text));
		postService.savePost(post);
		return new ResponseEntity<>(post, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> getAllPosts(){
		return postService.findAll();
	}
	
	@RequestMapping(path="upvote", method = RequestMethod.POST)
	public ResponseEntity<Post> upVote(@RequestParam Long id) throws IdNotFoundException {
		Post post = postService.findById(id);
		long value = post.getUpvotes();
		post.setUpvotes(value + 1);
		postService.savePost(post);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
}
