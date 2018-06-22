import React from 'react';
import {shallow} from 'enzyme';
import Enzyme from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Toolbar from '../components/Toolbar'
import ShallowRenderer from 'react-test-renderer/shallow';;
Enzyme.configure({ adapter: new Adapter() });

describe('Testing PostView.js', () =>{
	it('should render correctly...', () =>{
		const renderer = new ShallowRenderer();
		renderer.render(<Toolbar />);
	  	const tree = renderer.getRenderOutput();
  		expect(tree).toMatchSnapshot();
	});
});