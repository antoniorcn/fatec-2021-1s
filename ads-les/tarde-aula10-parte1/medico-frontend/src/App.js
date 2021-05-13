import React from "react";
import Medicos from "./Componentes/Medicos";
import Login from "./Componentes/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ContextoPrincipal from './Contextos/EstadoGlobal';

function cabecalho() { 
  return (
    <p>Bem vindo ao sistema</p>
  );
}


class Principal extends React.Component { 
  render() { 
    return (
      <ContextoPrincipal.Consumer> 
        {(contexto) =>
          <Router>
          <div className="container">
            <p>Token ({contexto.token})</p>
            {cabecalho()}
              <Switch>
                <Route path="/login" render={Login} component={Login}/>
                <Route path="/" render={Medicos} component={Medicos}/>
              </Switch>
          </div>
          </Router>
        }
      </ContextoPrincipal.Consumer> 
    );
  }
}

export default Principal;