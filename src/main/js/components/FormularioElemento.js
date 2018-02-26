import React from "react";
import { addElemento } from "../actions/elementoActions"

export default class FormularioElemento extends React.Component {

  constructor() {
    super();
    this.state = {

      name: "",
      estado: ""
    
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
      this.addUser();
    }
  }

  addUser() {
    addElemento(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <input type="text" class="form-control"
            name="name"
            placeholder="anade un elemento"
            value={this.state.name}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            name="estado"
            placeholder="anade un estado"
            value={this.state.estado}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addUser.bind(this)}>Insert Elementos</button>
        </div>
      </div>
    );
  }
}