const React = require('react');
const ReactDOM = require('react-dom')
import Menu from '../../containers/menu'

require('./headerView.css')
export default class Header extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return (
			<header>
				<Menu />
			</header>
		)
	}
}