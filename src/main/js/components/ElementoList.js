import React from "react";
import Elemento from "./Elemento"
import ElementoCount from "./ElementoCount"

export default class ElementoList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { elementos: [] }
	}

  render() {
		if (this.state.elementos.length == 0) {	
			fetch('/api/v1/element/list/')
			.then((response) => {
				return response.json();
			})			
			.then((elemento) => {
        		this.setState({ elementos: elemento })
      		})
			
		}

		if (this.state.elementos.length > 0) {
		
			var vectorElementos = [];
			this.state.elementos.forEach(
				(elementoA) => {
					vectorElementos.push(<Elemento elemento={elementoA} />)
				}
			)
		
		return (
				<div>
					{vectorElementos}
					<ElementoCount  count={vectorElementos.length}/>
				</div>
			)
			
		
		} else {
			return <p className="text-center">Loading elementos...</p>
		}


    
  }
}