const React = require('react');
const ReactDOM = require('react-dom')
import HeaderView from '../headerView'
import ContentView from '../contentView'

require('./rootView.css')
export default class RootView extends React.Component {
	constructor(props) {
		super(props)
	}
	render() {
		return (
			<div>
				<HeaderView />
				<ContentView
					animais={ this.props.animais }
				/>
			</div>
		)
	}
}