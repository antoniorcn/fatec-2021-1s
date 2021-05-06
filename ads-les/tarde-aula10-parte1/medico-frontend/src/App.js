import React from "react";
import Medicos from "./Componentes/Medicos";
import Login from "./Componentes/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ContextoPrincipal from './Contextos/ContextoPrincipal';
import EstadoGlobal from "./Contextos/EstadoGlobal";

function cabecalho() { 
  return (
    <p>Bem vindo ao sistema</p>
  );
}


class Principal extends React.Component { 
  render() { 
    return (
      <EstadoGlobal>
        <Router>
        <div className="container">
          <p>Token ({this.context.token})</p>
          {cabecalho()}
            <Switch>
              <Route path="/login" render={Login} component={Login}/>
              <Route path="/" render={Medicos} component={Medicos}/>
            </Switch>
        </div>
        </Router>
      </EstadoGlobal>
    );
  }
}

Principal.contextType = ContextoPrincipal;

export default Principal;