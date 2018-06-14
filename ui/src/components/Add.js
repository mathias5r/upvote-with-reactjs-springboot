import React, { Component } from 'react';
import axios from 'axios';
import {Button} from 'react-bootstrap'
import Alert from 'react-s-alert';
import './AddView.css';

import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

class Add extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
			author: '',
			text: ''
	  	};
  	}

	updateAuthor(evt){
		this.setState({
		  author: evt.target.value
		});
	}

	updateText(evt){
		this.setState({
		  text: evt.target.value
		});
	}

	performPostRequest() {
		const params = new URLSearchParams();
		params.append('author', this.state.author);
		params.append('text', this.state.text);

		axios.post('http://localhost:8080/post', params)
			.then(res => {
				this.setState({
					author: '',
					text: ''
				});
		        Alert.info('Comentário adicionado com sucesso',{
		        	position: 'bottom-right'
		        });
		});
	}

	render() {
    	return (
		<div className="container">
			<div className="jumbotron jumbo">
				<Alert stack={{limit: 2}} />
				<div>
					<div className="form-group"></div>
					<label>Nome:</label>
					<input type="text" className="form-control" id="usr" onChange={evt => this.updateAuthor(evt)} value={this.state.author}/>
				</div>
				<div className="form-group">
					<label>Comentário:</label>
					<textarea className="form-control" rows="5" id="comment" onChange={evt => this.updateText(evt)} value={this.state.text}></textarea>
			</div>
			</div>  
				<div className="adicionar">
					<Button 
					onClick={this.performPostRequest.bind(this)}
					>Adicionar</Button>
				</div>
		</div>
    	);
  	}	
}
export default Add;