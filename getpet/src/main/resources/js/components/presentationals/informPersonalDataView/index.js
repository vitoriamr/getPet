const React = require('react');
const ReactDOM = require('react-dom')

require('./informPersonalDataView.css')
export default class InformPersonalDataView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	selectPessoaFisica() {
		return () => {
			this.props.selectPersonType( 'pf' )
		}
	}
	
	selectPessoaJuridica() {
		return () => {
			this.props.selectPersonType( 'pj' )
		}
	}
	
	getPessoaOptions() {
		if ( this.props.profile === 'cuidador' ) {
			return (
				<section className={ 'inform-personal-data__row' }>
					<section
						className={ `inform-personal-data__choice${ this.props.data.pf ? '--selected' : '' }` }
						onClick={ this.selectPessoaFisica() }
					>
						{ 'PESSOA FÍSICA' }
					</section>
					<section
						className={ `inform-personal-data__choice${ this.props.data.pf ? '' : '--selected' }` }
						onClick={ this.selectPessoaJuridica() }
					>
						{ 'PESSOA JURÍDICA' }
					</section>
				</section>
			)
		}
	}
	
	getCPFCNPJField() {
		if ( this.props.data.pf || this.props.profile === 'adotante' ) {
			return (
				<section className={ 'inform-personal-data__row' }>
					<label
						className={ 'inform-personal-data__label' }
						htmlFor={ 'cpf' }
					>
						{ 'Informe seu CPF:' }
					</label>
					<input
						className={ 'inform-personal-data__input' }
						id={ 'cpf' }
						name={ 'cpf' }
						onChange={ this.props.handleChange }
						type={ 'tel' }
						value={ this.props.data.cpf }
					/>
				</section>
			)
		} else {
			return (
				<section className={ 'inform-personal-data__row' }>
					<label
						className={ 'inform-personal-data__label' }
						htmlFor={ 'cnpj' }
					>
						{ 'Informe seu CNPJ:' }
					</label>
					<input
						className={ 'inform-personal-data__input' }
						id={ 'cnpj' }
						name={ 'cnpj' }
						onChange={ this.props.handleChange }
						type={ 'tel' }
						value={ this.props.data.cnpj }
					/>
				</section>
			)
		}
	}
	
	render() {
		return (
			<div className={ `inform-personal-data` }>
				<section className={ 'inform-personal-data__row' }>
					<label
						className={ 'inform-personal-data__label' }
						htmlFor={ 'name' }
					>
						{ 'Nome:' }
					</label>
					<input
						className={ 'inform-personal-data__input' }
						id={ 'name' }
						name={ 'name' }
						onChange={ this.props.handleChange }
						type={ 'text' }
						value={ this.props.data.name }
					/>
				</section>
				<section className={ 'inform-personal-data__row' }>
					<label
						className={ 'inform-personal-data__label' }
						htmlFor={ 'email' }
					>
						{ 'E-mail:' }
					</label>
					<input
						className={ 'inform-personal-data__input' }
						id={ 'email' }
						name={ 'email' }
						onChange={ this.props.handleChange }
						type={ 'email' }
						value={ this.props.data.email }
					/>
				</section>
				<section className={ 'inform-personal-data__row' }>
					<label
						className={ 'inform-personal-data__label' }
						htmlFor={ 'tel' }
					>
						{ 'Telefone para contato:' }
					</label>
					<input
						className={ 'inform-personal-data__input' }
						id={ 'tel' }
						name={ 'tel' }
						onChange={ this.props.handleChange }
						type={ 'tel' }
						value={ this.props.data.tel }
					/>
				</section>
				{ this.getPessoaOptions() }
				{ this.getCPFCNPJField() }
				<section className={ 'inform-personal-data__row--buttons' }>
					<section
						className={ 'inform-personal-data__button--next-step' }
						onClick={ this.props.completePersonalDataStep }
					>
						{ 'Próximo passo' }
					</section>
				</section>
			</div>
		)
	}
}