import React, { Component } from 'react';
import upvote from '../resources/upvote.png';
import {postUpvote} from './API'
import Alert from 'react-s-alert';

class Post extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
	    	post:props.post
	  	};
	  	this.upvotePost = this.upvotePost.bind(this);
  	}

	upvotePost(id){
		const params = new URLSearchParams();
	    params.append('id', id);
	    postUpvote(params).then(res =>{
	    	const post = res.data;
	 		this.setState({ post });
	    }).catch(error =>{
	        Alert.error('Erro ao tentar executar upvote!',{
	        	position: 'bottom-right'
	        });
  		});
	}

	render(){
		return (
			<div>
				<div className="row">
					<div className="col-md-auto">
					 	<p>{this.state.post.author}</p>
					</div>
					<div className="col-md-auto">
					 	<p>{this.state.post.date}</p>
					</div>
				</div>
				<div className="text-box rounded">
					<textarea maxlength="250" className="form-control" rows="5" id="comment" value={this.state.post.text}></textarea>
				</div>
				<div className="outer">
					<input onClick={() => this.upvotePost(this.state.post.id)} className="upvotes" type="image" src={upvote} alt="upvote"/>
					<p className="upvotesvalue">{this.state.post.upvotes}</p>
				</div>
			</div>
		);
	}
}
export default Post;