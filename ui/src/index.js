import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './components/App';
import PostView from './components/PostView'
import Toolbar from './components/Toolbar'
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<Toolbar />, document.getElementById('home-button'));
ReactDOM.render(<PostView />, document.getElementById('body'));

registerServiceWorker();
