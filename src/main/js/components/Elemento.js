import React from "react";
import Boton from "./Boton"
import Delete from "./Delete"
export default class Elemento extends React.Component {

	constructor(props) {
		super(props)
	}

  render() {

    const { elemento } = this.props;
  
    return (
      <div class="well col-md-4 col-md-offset-4" key={elemento.name}>
        name: {elemento.name} estado: {elemento.estado}<br/>
        <Boton id={elemento.name}/>
        <Delete id={elemento.name}/>
      </div> 
    );
  }
}
