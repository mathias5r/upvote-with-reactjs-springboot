import React, { Component } from 'react';
import './PostView.css';
import Post from './Post'
import { getPosts } from './API'
import Alert from 'react-s-alert';

class PostView extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
	    	posts: []
	  	};
  	}

  	componentDidMount() {
  		getPosts().then(res =>{
      		const posts = res.data;
     		posts.reverse();
     		this.setState({ posts });
  		}).catch(error =>{
	        Alert.error('Erro ao tentar obter posts!',{
	        	position: 'bottom-right'
	        });
  		})
	}

  	render() {
    	return (
    		<div className="container">
    			<Alert stack={{limit: 2}} />
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

