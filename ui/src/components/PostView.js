import React, { Component } from 'react';
import axios from 'axios';
import './PostView.css';
import Post from './Post'

class PostView extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
	    	posts: []
	  	};
  	}

  	componentDidMount() {
	    axios.get('http://localhost:8080/posts').then(res => {
      		const posts = res.data;
      		posts.reverse();
      		this.setState({ posts });
	    });
	}

  	render() {
    	return (
    		<div className="container">
				{this.state.posts.map(post => (
					<ul className="list-group">
						<div className="jumbotron jumbo">
							<li key={post.id}>
								<Post post={post} />						
							</li>
						</div>
					</ul>
				))}		
			</div>
    	);
  	}
}
export default PostView;

