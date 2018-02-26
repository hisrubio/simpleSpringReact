import React from "react"
import { addUser } from "../actions/userActions"
import AddUserForm from "./AddUserForm"
import UserList from "./UserList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
        <AddUserForm />
        <UserList />
      </div>
    )
  }
}
