const React = require('react');
const ReactDOM = require('react-dom')
import AnimalsList from './animalsList'
import AnimalsFilterView from '../presentationals/animalsFilterView'

export default class AnimalsFilter extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			filterValues: {
				type: '',
			},
			visibleAnimals: props.animais,
			filters: {
				type: ( animals ) => { animals.filter( animal => animal.type === this.state.filterValues.type ) },
			}
		}
	}
	
	handleChange( event ) {
		let filters = Object.assign( {}, this.state.filters, { [ event.target.name ]: event.target.value } )
		this.setState( { filters }, this.filterAnimals )
	}
	
	filterAnimals() {
		let visibleAnimals
		for ( filter of Object.keys( this.state.filters ) ) {
			visibleAnimals = this.state.filters[ filter ]( visibleAnimals )
		}
		this.setState( { visibleAnimals } )
	}
	
	filter( fn ) {
		let visibleAnimals = fn( this.state.visibleAnimals )
		this.setState( { visibleAnimals } )
	}

	render() {
		return (
			<div>
				<h1 className={ `content__title` }>{ `Lista de Animais` }</h1>
				<AnimalsFilterView
					filters={ this.state.visibleAnimals }
				/>
				<AnimalsList
					animais={ this.state.visibleAnimals }
				/>
			</div>
		)
	}
}