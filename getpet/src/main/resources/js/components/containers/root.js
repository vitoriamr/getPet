const React = require('react');
const ReactDOM = require('react-dom')
import { Animal } from '../../models/animal'
import Menu from './menu'
import AnimalsList from './animalsList'

export default class Root extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			animais: []
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
	
	render() {
		return (
			<div>
				<header>
					<Menu />
				</header>
				<div>
					<AnimalsList
						animais={ this.state.animais }
					/>
				</div>
			</div>
		)
	}
}