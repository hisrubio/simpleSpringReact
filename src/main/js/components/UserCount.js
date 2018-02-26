import React from "react";


export default class UserCount extends React.Component {

	constructor(props) {
		super(props)
		this.state = { count: props.count }
	}

  render() {
		
		return (
				<div>
					se muestran {this.state.count} elementos
				</div>
			)
		

    
  }
}