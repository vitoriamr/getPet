const React = require('react');
const ReactDOM = require('react-dom')

require(`./animalView.css`)
export default class AnimalView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	complete() {
		return (
			<div className={ `animal` }>
				<div className={ `animal__fields` }>
					<p className={ `animal__fields__text--odd` }>{ `Nome:` }</p>
					<p className={ `animal__fields__text` }>{ `Espécie:` }</p>
					<p className={ `animal__fields__text--odd` }>{ `Raça:` }</p>
					<p className={ `animal__fields__text` }>{ `Sexo:` }</p>
					<p className={ `animal__fields__text--odd` }>{ `Idade:` }</p>
					<p className={ `animal__fields__text` }>{ `Castrado:` }</p>
					<p className={ `animal__fields__text--odd` }>{ `Tamanho:` }</p>
					<p className={ `animal__fields__text` }>{ `Doenças e Limitações:` }</p>
					<p className={ `animal__fields__text--odd` }>{ `Temperamento:` }</p>
					<p className={ `animal__fields__text` }>{ `Cuidador:` }</p>
					<p className={ `animal__fields__text--odd` }>{ `Unidade:` }</p>
					<p className={ `animal__fields__text` }>{ `Observações:` }</p>
				</div>
				<div className={ `animal__values` }>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.nome}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.especie}` }</p>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.raca}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.sexo}` }</p>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.idade}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.castrado}` }</p>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.tamanho}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.doencasLimitacoes}` }</p>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.temperamento}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.cuidador}` }</p>
					<p className={ `animal__values__text--odd` }>{ `${this.props.animal.unidade}` }</p>
					<p className={ `animal__values__text` }>{ `${this.props.animal.obs}` }</p>
				</div>
			</div>
		)
	}
	
	resumed() {
		return ( 
			<div className={ `animal--resumed` } onClick={ this.props.handleClick }>
				<div className={ `animal--resumed__fields` }>
					<p className={ `animal--resumed__fields__text` }>{ `Nome:` }</p>
					<p className={ `animal--resumed__fields__text` }>{ `Espécie:` }</p>
					<p className={ `animal--resumed__fields__text` }>{ `Raça:` }</p>
					<p className={ `animal--resumed__fields__text` }>{ `Sexo:` }</p>
					<p className={ `animal--resumed__fields__text` }>{ `Idade:` }</p>
				</div>
				<div className={ `animal--resumed__values`}>
					<p className={ `animal--resumed__values__text` }>{ `${this.props.animal.nome}` }</p>
					<p className={ `animal--resumed__values__text` }>{ `${ this.props.animal.especie }` }</p>
					<p className={ `animal--resumed__values__text` }>{ `${ this.props.animal.raca }` }</p>
					<p className={ `animal--resumed__values__text` }>{ `${ this.props.animal.sexo }` }</p>
					<p className={ `animal--resumed__values__text` }>{ `${ this.props.animal.idade }` }</p>
				</div>
				
			</div>
		)
	}
	
	render() {
		return this.props.resumed ? this.resumed() : this.complete()
	}
}
