import React from "react";


export default class Delete extends React.Component {

	constructor(props) {
		super(props)
		this.state = { id: props.id }
    }
    
    delete(event){
        fetch('/api/v1/user/delete/user/?id='+this.state.id)
        
    }

  render() {
		
		return (
				<button onClick={this.delete.bind(this)}>
					borrar dni
				</button>
			)
		

    
  }
}