const React = require('react');
const ReactDOM = require('react-dom')
import MenuView from '../presentationals/menuView'

export default class Menu extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return ( 
			<MenuView />
		)
	}
}