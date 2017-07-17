const React = require('react');
const ReactDOM = require('react-dom')
import Menu from '../../containers/menu'

require('./headerView.css')
export default class Header extends React.Component {
	constructor(props) {
		super(props)
	}
	
	getRightSection() {
		if ( false ) {
			return
		} else {
			return (
				<div
					className={ `header__signup__button` }
					onClick={ this.props.goToSignUp }
				>
					{ `CADASTRO` }
				</div>
			)
		}
	}
	
	render() {
		return (
			<header>
				<Menu />
				{ this.getRightSection() }
			</header>
		)
	}
}