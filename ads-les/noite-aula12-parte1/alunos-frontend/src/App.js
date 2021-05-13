import React from 'react';
import AlunoApp from './componentes/Aluno';
import Login from './componentes/Login';

import {Route, BrowserRouter as Router, Switch} from 'react-router-dom';
import Contexto from './contexto/ContextoPrincipal';

class App extends React.Component { 

  static contextType = Contexto;

  render() { 
    return (
      <div>
        <Router>
          <Switch>
            <Route path="/login" component={Login}/>
            <Route path="/aluno" component={AlunoApp}/>
          </Switch>
        </Router>
      </div>
    );
  }

}

export default App;