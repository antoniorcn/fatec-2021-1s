import React from "react";
import Medicos from "./Componentes/Medicos";
import Login from "./Componentes/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Contexto from "./Contextos/ContextoPrincipal";

function cabecalho() { 
  return (
    <p>Bem vindo ao sistema</p>
  );
}


class Principal extends React.Component { 

  static contextType = Contexto;

  render() { 
    return (
      <Router>
      <div className="container">
        <p>Token: {this.context.token}</p>
        {cabecalho()}
          <Switch>
            <Route path="/login" component={Login}/>
            <Route path="/" component={Medicos}/>
          </Switch>
      </div>
      </Router>
    );
  }
}

export default Principal;