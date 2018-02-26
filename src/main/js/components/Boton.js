import React from "react";


export default class Boton extends React.Component {

	constructor(props) {
		super(props)
		this.state = { name: props.id }
    }
    
    boton(event){
				console.log(this.state.name)
        fetch('/api/v1/element/cambiar/?id='+this.state.name)
        
    }

  render() {
		
		return (
				<button onClick={this.boton.bind(this)}>
					cambiar estado
				</button>
			)
		

    
  }
}