const React = require('react');
const ReactDOM = require('react-dom')
import AnimalListView from '../presentationals/animalListView'
import AnimalView from '../presentationals/animalView'

const VIEW_ANIMAL = `VIEW_ANIMAL`
const VIEW_LIST = `VIEW_LIST`
export default class AnimalsList extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			action: VIEW_LIST,
			animal: {}
		}
	}
	
	setViewAsList() {
		this.setState({ action: VIEW_LIST, animal: {} })
	}
	
	setViewAsAnimal(animal) {
		this.setState({ action: VIEW_ANIMAL, animal })
	}
	
	handleAnimalOnClick(id) {
		this.setViewAsAnimal(this.props.animais.filter( animal => animal.id === id )[0])
	}
	
	getCorrectView() {
		switch(this.state.action) {
			case VIEW_LIST: {
				return this.getListView()
			}
			case VIEW_ANIMAL: {
				return this.getAnimalView()
			}
		}
	}
	
	getListView() {
		return (
			<AnimalListView
				animais={ this.props.animais }
				handleAnimalOnClick={ this.handleAnimalOnClick.bind(this) }
			/>
		)
	}
	
	getAnimalView() {
		return (
			<div>
				<section className={ `button--back` } onClick={ this.setViewAsList.bind( this ) }>
					<p>{ `VOLTAR` }</p>
				</section>
				<AnimalView
					animal={ this.state.animal }
				/>
			</div>
		)
	}
	
	render() {
		return (
			<div>
				{ this.getCorrectView() }
			</div>
		)
	}
}