const React = require('react');
const ReactDOM = require('react-dom')

require(`./animalView.css`)
export default class AnimalView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return ( 
			<div className={ `animal` }>
				<div className={ `animal__fields` }>
					<p>{ `Nome:` }</p>
					<p>{ `Espécie:` }</p>
					<p>{ `Raça:` }</p>
					<p>{ `Sexo:` }</p>
					<p>{ `Idade:` }</p>
				</div>
				<div className={ `animal__values`}>
					<p>{ `${this.props.animal.nome}` }</p>
					<p>{ `${ this.props.animal.especie }` }</p>
					<p>{ `${ this.props.animal.raca }` }</p>
					<p>{ `${ this.props.animal.sexo }` }</p>
					<p>{ `${ this.props.animal.idade }` }</p>
				</div>
				
			</div>
		)
	}
}
