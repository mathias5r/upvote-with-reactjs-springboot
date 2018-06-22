import axios from 'axios';

function get(url){
    return axios.get(url);
}

function post(url, params){
    return axios.post(url,params);
}

export function getPosts(){
	return get('http://localhost:8080/posts');
}

export function postUpvote(params){
	return post('http://localhost:8080/upvote',params);
}

export function postNewPost(params){
	return post('http://localhost:8080/post',params);
}


