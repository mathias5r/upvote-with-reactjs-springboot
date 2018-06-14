import React, { Component } from 'react';
import upvote from '../resources/upvote.png';
import axios from 'axios';

class Post extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
	    	post:props.post
	  	};
  	}

	printPostId(id){
		const params = new URLSearchParams();
	    params.append('id', id);

	    axios.post('http://localhost:8080/upvote', params).then(res => {
		   const post = res.data;
		   this.setState({ post });
		});
	}

	render(){
		return (
			<div>
				<div className="row">
					<div className="col">
						 <h5>{this.state.post.author}</h5>
					</div>
					<div className="col-md-auto">
						 	<p>{this.state.post.date}</p>
					</div>
				</div>
				<div className="text-box rounded">
					<p className="text">{this.state.post.text}</p>
				</div>
				<div className="outer">
					<input onClick={() => this.printPostId(this.state.post.id)} className="upvotes" type="image" src={upvote} alt="upvote"/>
					<p className="upvotes-value">{this.state.post.upvotes}</p>
				</div>
			</div>
		);
	}
}
export default Post;