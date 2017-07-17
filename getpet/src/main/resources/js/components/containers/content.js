const React = require('react');
const ReactDOM = require('react-dom')
import AnimalsFilter from './animalsFilter'
import SignUp from './signUp'

export default class Content extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			visibleAnimals: props.animais,
		}
	}
	
	getCorrectView() {
		switch ( this.props.page ) {
		case 'listView':
			return (
				<AnimalsFilter
					animais={ this.props.animais }
				/>
			)
		case 'signUpView':
			return (
				<SignUp />
			)
		}
	}
	
	render() {
		return (
			<div className={ 'content' }>
				{ this.getCorrectView() }
			</div>
		)
	}
}