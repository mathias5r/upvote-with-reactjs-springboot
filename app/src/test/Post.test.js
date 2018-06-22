import React from 'react';
import {shallow} from 'enzyme';
import Enzyme from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Post from '../components/Post'
import ShallowRenderer from 'react-test-renderer/shallow';
import MockAdapter from 'axios-mock-adapter';
import axios from 'axios';
Enzyme.configure({ adapter: new Adapter() });

const post = { id: 100,
author: 'Mathias',
text: 'Test',
date: '88/88/2018',
upvotes: 0 };

describe('Testing Post.js', () =>{
	it('should render correctly...', () =>{
		const renderer = new ShallowRenderer();
		renderer.render(<Post post={post} />);
	  	const tree = renderer.getRenderOutput();
  		expect(tree).toMatchSnapshot();
	})
	it('should call upvotePost...',() => {
    	const spy = jest.spyOn(Post.prototype, 'upvotePost');
		const wrapper = shallow(<Post post={post} />);
		wrapper.find('input').simulate('click');
	  	expect(spy).toHaveBeenCalled();
	});
});


