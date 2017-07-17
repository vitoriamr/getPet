const React = require('react');
const ReactDOM = require('react-dom')

require( './selectProfileView.css' )
export default class SelectProfileView extends React.Component {
	constructor(props) {
		super(props)
	}

	selectProfile( profile ) {
		return () => {
			return this.props.selectProfile( profile )
		}
	}
	
	render() {
		return (
			<div className={ 'select-profile' }>
				<div
					className={ 'select-profile__item' }
					onClick={ this.selectProfile( 'cuidador' ) }
				>
					<div className={ 'select-profile__item__title' }>
						{ 'CUIDADOR' }
					</div>
					<div className={ 'select-profile__item__description' }>
						<p>{ 'Você não pode mais cuidar de um bichinho e quer deixá-lo aos cuidados de otra pessoa? Clique aqui e faça seu cadastro!' }</p>
					</div>
				</div>
				<div
					className={ 'select-profile__item' }
					onClick={ this.selectProfile( 'adotante' ) }
				>
					<div className={ 'select-profile__item__title' }>
						{ 'ADOTANTE' }
					</div>
					<div className={ 'select-profile__item__description' }>
						<p>{ 'Você está à procura de um bichinho para alegrar sua vida? Clique aqui e faça seu cadastro!' }</p>
					</div>
				</div>
			</div>
		)
	}
}