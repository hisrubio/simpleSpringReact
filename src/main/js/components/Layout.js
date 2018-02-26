import React from "react"
import FormularioElemento from "./FormularioElemento"
import ElementoList from "./ElementoList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
        <FormularioElemento />
        <ElementoList />
      </div>
    )
  }
}
