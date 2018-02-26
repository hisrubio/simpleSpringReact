import React from "react";
import { addUser } from "../actions/userActions"

export default class AddUserForm extends React.Component {

  constructor() {
    super();
    this.state = {

      nombre: "",
      apellido: "",
      dni: ""
    
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
      this.addUser();
      console.log("item inserted")
    }
  }

  addUser() {
    addUser(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <input type="text" class="form-control"
            name="nombre"
            placeholder="Add a new user name..."
            value={this.state.nombre}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            name="apellido"
            placeholder="Add a new user apellido..."
            value={this.state.apellido}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            placeholder="Add a new user document id..."
            name="dni"
            value={this.state.dni}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addUser.bind(this)}>Insert User</button>
        </div>
      </div>
    );
  }
}