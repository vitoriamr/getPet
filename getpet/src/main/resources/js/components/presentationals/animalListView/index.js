const React = require('react');
const ReactDOM = require('react-dom')
import AnimalView from '../animalView'

require(`./animalListView.css`)
export default class AnimalListView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	handleClick(id) {
		return () => {
			this.props.handleAnimalOnClick(id)
		}
	}
	
	render() {
		let lista = this.props.animais.map(animal => {
			return (
				<AnimalView
					animal={ animal }
					handleClick={ this.handleClick(animal.id) }
					key={ `animal.${animal.id}` }
					resumed
				/>
			)
		})
		return (
			<div className={ `lista-animais` }>
				{ lista }
			</div>
		)
	}
}