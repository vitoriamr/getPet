const React = require('react');
const ReactDOM = require('react-dom')
import AnimalView from '../animalView'

require(`./animalListView.css`)
export default class AnimalListView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		let lista = this.props.animais.map(animal => {
			return (
				<AnimalView
					animal={ animal }
					key={ `animal.${animal.id}` }
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