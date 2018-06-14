import React from 'react';
import ReactDOM from 'react-dom';
import { Component } from 'react';
import PostView from './PostView'
import AddView from './AddView'
import {Button, ButtonGroup} from 'react-bootstrap'
import './Toolbar.css';

class Toolbar extends Component{

	constructor(props, context) {
	    super(props, context);

	    this.handleHomeClick = this.handleHomeClick.bind(this);
	    this.handleAddClick = this.handleAddClick.bind(this);
  	}

	handleHomeClick() {
		ReactDOM.render(<PostView />, document.getElementById('body'));
	}

	handleAddClick() {
		ReactDOM.render(<AddView />, document.getElementById('body'));
	}


	render() {
    	return (
    		<ButtonGroup>
				<Button  onClick={this.handleHomeClick} >Home</Button>
				<Button  onClick={this.handleAddClick}>Adicionar</Button>
			</ButtonGroup>
    	);
  	}
}
export default Toolbar;