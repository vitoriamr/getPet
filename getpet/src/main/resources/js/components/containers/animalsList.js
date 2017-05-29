const React = require('react');
const ReactDOM = require('react-dom')
import AnimalListView from '../presentationals/animalListView'

export default class AnimalsList extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return ( 
			<div>
				<p>{ `Lista de animais` }</p>
				<AnimalListView
					animais={ this.props.animais }
				/>
			</div>
		)
	}
}