const React = require('react');
const ReactDOM = require('react-dom')

require('./informAdditionalDataView.css')
export default class InformPersonalDataView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	getPFFields() {
		if ( this.props.pf ) {
			return (
				<div>
					<section className={ 'inform-additional-data__row' }>
						<label
							className={ 'inform-additional-data__label' }
							htmlFor={ 'numOfAdoptions' }
						>
							{ 'Quantos animais você já adotou?' }
						</label>
						<input
							className={ 'inform-additional-data__input' }
							id={ 'numOfAdoptions' }
							name={ 'numOfAdoptions' }
							onChange={ this.props.handleChange }
							type={ 'tel' }
							value={ this.props.data.numOfAdoptions }
						/>
					</section>
					<section className={ 'inform-additional-data__row' }>
						<label
							className={ 'inform-additional-data__label' }
							htmlFor={ 'numOfAnimals' }
						>
							{ 'Quantos animais você possui?' }
						</label>
						<input
							className={ 'inform-additional-data__input' }
							id={ 'numOfAnimals' }
							name={ 'numOfAnimals' }
							onChange={ this.props.handleChange }
							type={ 'tel' }
							value={ this.props.data.numOfAnimals }
						/>
					</section>
				</div>
			)
		}
	}
	
	render() {
		return (
			<div className={ `inform-additional-data` }>
				{ this.getPFFields() }
				<section className={ 'inform-additional-data__row' }>
					<label
						className={ 'inform-additional-data__label' }
						htmlFor={ 'socialNetworks' }
					>
						{ 'Link para perfil em rede social:' }
					</label>
					<input
						className={ 'inform-additional-data__input' }
						id={ 'socialNetworks' }
						name={ 'socialNetworks' }
						onChange={ this.props.handleChange }
						type={ 'text' }
						value={ this.props.data.socialNetworks }
					/>
				</section>
				<section className={ 'inform-additional-data__row--buttons' }>
					<section
						className={ 'inform-additional-data__button--save' }
						onClick={ this.props.signUp }
					>
						{ 'Cadastrar!' }
					</section>
				</section>
			</div>
		)
	}
}