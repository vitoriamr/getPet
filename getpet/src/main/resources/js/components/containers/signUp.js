const React = require('react');
const ReactDOM = require('react-dom')
import SelectProfileView from '../presentationals/selectProfileView'
import InformPersonalDataView from '../presentationals/informPersonalDataView'
import InformAdditionalDataView from '../presentationals/informAdditionalDataView'

const PROFILE = 'profile'
const PERSONAL_DATA = 'personalData'
const ADDITIONAL_DATA = 'additionalData'

export default class SignUp extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = {
			additionalData: {
				numOfAdoptions: '',
				numOfAnimals: '',
				socialNetworks: '',
			},
			personalData: {
				pf: true,
				name: '',
				email: '',
				tel: '',
				cpf: '',
				cnpj: '',
				address: '',
			},
			step: PROFILE,
		}
	}
	
	signUp() {
		return
	}
	
	getStep() {
		switch ( this.state.step ) {
		case PROFILE:
			return (
				<SelectProfileView
					selectProfile={ this.selectProfile.bind( this ) }
				/>
			)
		case PERSONAL_DATA:
			return (
				<InformPersonalDataView
					completePersonalDataStep={ this.completePersonalDataStep.bind( this ) }
					data={ this.state.personalData }
					handleChange={ this.handleChange.bind( this ) }
					profile={ this.state.profile }
					selectPersonType={ this.selectPersonType.bind( this ) }
				/>
			)
		case ADDITIONAL_DATA:
			return (
				<InformAdditionalDataView
					data={ this.state.additionalData }
					pf={ this.state.personalData.pf }
					signUp={ this.signUp.bind( this ) }
				/>
			)
		}
	}
	
	goToStep( step ) {
		return () => {
			switch ( step ) {
			case PROFILE:
				if ( this.state.step === PERSONAL_DATA || this.state.step === ADDITIONAL_DATA ) {
					this.setState( { step } )
				}
			case PERSONAL_DATA:
				if ( this.state.step === ADDITIONAL_DATA ) {
					this.setState( { step } )
				}
			default:
				return
			}
		}
	}
	
	selectPersonType( personType ) {
		let personalData = Object.assign( {}, this.state.personalData, { pf: personType === 'pf' } )
		this.setState( { personalData } )
	}
	
	selectProfile( profile ) {
		this.setState( { profile, step: PERSONAL_DATA } )
	}
	
	completePersonalDataStep() {
		this.setState( { step: ADDITIONAL_DATA } )
	}
	
	handleChange( event ) {
		if ( this.state.step === PERSONAL_DATA ) {
			let personalData = Object.assign( {}, this.state.personalData, { [ event.target.name ]: event.target.value } )
			this.setState( { personalData } )
		} else if ( this.state.step === ADDITIONAL_DATA ) {
			let additionalData = Object.assign( {}, this.state.additionalData, { [ event.target.name ]: event.target.value } )
			this.setState( { additionalData } )
		}
	}
	
	render() {
		return (
			<div className={ 'sign-up' }>
				<div className={ 'sign-up__steps' }>
					<div
						className={ `sign-up__steps__step${ this.state.step === PROFILE ? '--active' : '--completed' }` }
						onClick={ this.goToStep( PROFILE ) }
					>
						{ 'Escolha seu perfil' }
					</div>
					<div
						className={ `sign-up__steps__step${ this.state.step === PERSONAL_DATA ? '--active' : ( this.state.step === ADDITIONAL_DATA ? '--completed' : '' ) }` }
						onClick={ this.goToStep( PERSONAL_DATA ) }
					>
						{ 'Preencha seus dados pessoais' }
					</div>
					<div
						className={ `sign-up__steps__step${ this.state.step === ADDITIONAL_DATA ? '--active' : '' }` }
						onClick={ this.goToStep( ADDITIONAL_DATA ) }
					>
					{ 'Informações adicionais' }
				</div>
				</div>
				{ this.getStep() }
			</div>
		)
	}
}