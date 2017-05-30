const React = require('react');
const ReactDOM = require('react-dom')
import AnimalsList from '../../containers/animalsList'

require('./contentView.css')
export default class ContentView extends React.Component {
	constructor(props) {
		super(props)
	}
	render() {
		return (
			<div className={ `content` }>
				<AnimalsList
					animais={ this.props.animais }
				/>
			</div>
		)
	}
}