const React = require('react');
const ReactDOM = require('react-dom')

require('./animalsFilterView.css')
export default class AnimalsFilterView extends React.Component {
	constructor(props) {
		super(props)
	}
	
	render() {
		return (
			<div>
				<label
					className={ 'animals-filter__label' }
					htmlFor={ 'type' }
				>
					{ 'Selecione o tipo de animal:' }
				</label>
				<select
					className={ 'animals-filter__input' }
					id={ 'type' }
					name={ 'type' }
					onChange={ this.props.byType }
					type={ 'select' }
					value={ this.props.type }
				>
					<option value={ 'cat' }>{ 'Gato' }</option>
					<option value={ 'dog' }>{ 'Cachorro' }</option>
				</select>
			</div>
		)
	}
}