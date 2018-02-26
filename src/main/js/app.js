import React from "react"
import ReactDOM from "react-dom"
import { Provider } from "react-redux"

import Layout from "./components/Layout"

const app = document.getElementById('app')

ReactDOM.render(
  <Layout />, app);
