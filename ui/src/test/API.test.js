
var assert = require('assert');
var api = require('../components/API');

describe('Testing API', () =>{
	var newPost = it('should post a new Post...', () =>{
		const author = 'MochaTest';
		const test = author;
		const params = new URLSearchParams();
		params.append('author', 'Jest test');
		params.append('text', 'Jest test');
		api.postNewPost(params).then(res => {
			const post = res.data;
			expected(post.author).toEqual(author);
			expected(post.test).toEqual(text);
			return post;
		});
	})
	it('should get all posts...',() =>{
		api.getPosts().then(res =>{
			const posts = res.data;
			expected(posts).toContain(newPost);
		})
	})
	it('should upvote the new Post...',() =>{
		const id = newPost.id;
		const upvotes = newPost.upvotes;
		const params = new URLSearchParams();
		params.append('id', id);
		api.postUpvote(params).then(res =>{
			const post = res.data;
			expected(post.id).toEqual(id);
			expected(post.upvotes).toBeGreaterThan(upvotes);
		})
	})
})

