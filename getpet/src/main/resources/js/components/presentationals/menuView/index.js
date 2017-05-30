const React = require('react');
const ReactDOM = require('react-dom')

require('./menuView.css')
export default class MenuView extends React.Component {
	constructor(props) {
		super(props)
		
		this.state = { showItems: false }
	}
	
	hideItems() {
		this.setState({ showItems: false })
	}
	
	showItems() {
		this.setState({ showItems: true })
	}
	
	getItems() {
		if(this.state.showItems) {
			return (
				<nav className={ `menu` } onMouseLeave={ this.hideItems.bind(this) }>
					<section className={ `menu__button` }>{ `MENU` }</section>
					<section className={ `menu__links--container` }>
						<section className={ `menu__links` }>
							<a href={ `/` } className={ `menu__links__item` }>{ `Início` }</a>
							<a href={ `/` } className={ `menu__links__item` }>{ `Pesquisar` }</a>
							<a href={ `/` } className={ `menu__links__item` }>{ `Contribuições` }</a>
							<a href={ `/` } className={ `menu__links__item` }>{ `Animais adotados` }</a>
							<a href={ `/` } className={ `menu__links__item` }>{ `Depoimentos` }</a>
						</section>
					</section>
				</nav>
			)
		} else {
			return (
				<div className={ `menu` } onMouseEnter={ this.showItems.bind(this) }>
					<section className={ `menu__button` }>{ `MENU` }</section>
				</div>
			)
		}
	}
	
	render() {
		return this.getItems()
	}
}