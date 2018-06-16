import React from 'react';
import {shallow} from 'enzyme';
import Enzyme from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Add from '../components/Add'
import ShallowRenderer from 'react-test-renderer/shallow';
import MockAdapter from 'axios-mock-adapter';
import axios from 'axios';
Enzyme.configure({ adapter: new Adapter() });

describe('Testing Add.js', () =>{
	it('should render correctly...', () =>{
		const renderer = new ShallowRenderer();
		renderer.render(<Add />);
	  	const tree = renderer.getRenderOutput();
  		expect(tree).toMatchSnapshot();
	});
	it('should update author...',() =>{
		const spy = jest.spyOn(Add.prototype, 'updateAuthor');
	 	const event = {target: {id: "usr", value: "test"}};
		const wrapper = shallow(<Add />);
		wrapper.find('input').simulate('change', event);
	  	expect(spy).toHaveBeenCalled();
	});
	it('should update text...',() =>{
		const spy = jest.spyOn(Add.prototype, 'updateText');
	 	const event = {target: {id: "comment", value: "test"}};
		const wrapper = shallow(<Add />);
		wrapper.find('textarea').simulate('change', event);
	  	expect(spy).toHaveBeenCalled();
	});
	it('should call createPost...',() =>{
		const spy = jest.spyOn(Add.prototype, 'createPost');
		const wrapper = shallow(<Add />);
		wrapper.find('Button').simulate('click');
	  	expect(spy).toHaveBeenCalled();
	});
});