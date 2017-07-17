const React = require('react');
const ReactDOM = require('react-dom')
import { Animal } from '../../models/animal'
import RootView from '../presentationals/rootView'

export default class Root extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			animais: [],
			page: 'listView'
		}
	}
	
	componentDidMount() {
		fetch('/api/animais')
			.then(response => {
				return response.json()
			})
			.then(json => {
				let animais = json.map(animal => new Animal(animal))
				this.setState({ animais: animais })
			})
	}
	
	goToSignUp() {
		let page = 'signUpView'
		this.setState( { page } )
	}
	
	render() {
		return (
			<RootView
				animais={ this.state.animais }
				goToSignUp={ this.goToSignUp.bind( this ) }
				page={ this.state.page }
			/>
		)
	}
}