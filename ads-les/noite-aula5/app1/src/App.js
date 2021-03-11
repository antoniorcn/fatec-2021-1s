import React from 'react';
import axios from "axios";

class TabelaAlunos extends React.Component { 

  render() { 
    const lista = this.props.state.lista;
    const listaDisplay = [];
    for (let i = 0; i < lista.length; i++) { 
      listaDisplay.push(
          <tr>
              <td>{lista[i].ra}</td>
              <td>{lista[i].nome}</td>
              <td>{lista[i].nascimento}</td>
          </tr>
      );
    }
    return (
      <div>
        <h2>Tabela de Alunos</h2>
        <table className="table table-striped">
          <thead>
            <tr>
              <th>RA</th>
              <th>Nome</th>
              <th>Nascimento</th>
            </tr>
          </thead>
          <tbody>
            {listaDisplay}
          </tbody>
        </table>
      </div>
    );
  }
}

function LabelInput(props) { 
  return(
    <div className="form-group">
      <label>{props.label}</label>
      <input  type="TEXT" value={props.value} 
              className="form-control"
              onChange={(e) => {
                if(props.atualizarTexto) { 
                  props.atualizarTexto(e.target.value);
                }
              }}/>
    </div>
  );
}

class App extends React.Component {
  state = {
    alunoAtual: {
      ra: "",
      nome: "",
      nascimento: ""
    },
    lista: [
    ]
  }

  componentDidMount() { 
      axios.get(
        `http://localhost:8080/noite-aula4-web/alunos`,
          {
            responseType: 'json',
          }
        ).then(
        (response) => {
          console.log(response);
          const novoState = {...this.state};
          novoState.lista = response.data;
          this.setState(novoState);
        }
      );
      console.log("Alunos carregados");
  }

  atualizarTexto(campo, txt) {
    const novoState = {...this.state};
    novoState.alunoAtual[campo] = txt;
    this.setState(novoState);
  }

  salvar() {
    const apiUrl = `http://localhost:8080/noite-aula4-web/adicionarAluno`;
        fetch(apiUrl, {
          method: 'POST',
          headers: {
            Accept: 'text/plain',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.state.alunoAtual)
        }).then(
          (response)=> {
            console.log(response.body);
            this.componentDidMount();
          }
        );

    //const newState = {...this.state};
    //newState.lista.push({...this.state.alunoAtual});
    //this.setState(newState);
  }

  render() {
    return (
      <div className="container">
        <h1>Gestão de Alunos</h1>
        <LabelInput label="RA:" corFundo="#DDDD00" 
                    value={this.state.alunoAtual.ra}
                    atualizarTexto={(txt) => this.atualizarTexto('ra', txt)}/>

        <LabelInput label="Nome:" corFundo="#DDDD00"
                    value={this.state.alunoAtual.nome}
                    atualizarTexto={(txt) => this.atualizarTexto('nome', txt)}/>

        <LabelInput label="Nascimento:" corFundo="#DDDD00"
                    value={this.state.alunoAtual.nascimento}
                    atualizarTexto={(txt) => this.atualizarTexto('nascimento', txt)}/>
        <button className="btn btn-primary"
            onClick={()=>{this.salvar()}}>Salvar</button>
        <TabelaAlunos state={this.state}/>
      </div>
    );
  }
}

export default App;

