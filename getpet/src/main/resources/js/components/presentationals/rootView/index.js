const React = require('react');
const ReactDOM = require('react-dom')
import HeaderView from '../headerView'
import Content from '../../containers/content'

require('./rootView.css')
export default class RootView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return (
			<div>
				<HeaderView
					goToSignUp={ this.props.goToSignUp }
				/>
				<Content
					animais={ this.props.animais }
					page={ this.props.page }
				/>
			</div>
		)
	}
}