import React from "react";


export default class Delete extends React.Component {

	constructor(props) {
		super(props)
		this.state = { name: props.id }
    }

    delete(event){
        console.log(this.state.name)
        fetch('/api/v1/element/delete/?id='+this.state.name)
			
	}

  render() {
		
		return (
            <button onClick={this.delete.bind(this)}>
            delete
            </button>
			)
		

    
  }
}