import React from 'react';
import axios from "axios";
const numero = 10;

class TabelaAlunos extends React.Component { 

  render() { 
    const lista = this.props.state.lista;
    const listaDisplay = [];
    for (let i = 0; i < lista.length; i++) { 
      listaDisplay.push(
          <p>{lista[i].ra} - {lista[i].nome}</p>
      );
    }
    return (
      <div>
        <h2>Tabela de Alunos</h2>
        {listaDisplay}
        <button>Alterar</button>
      </div>
    );
  }
}

function LabelInput(props) { 
  return(
    <div style={{backgroundColor: props.corFundo}}>
      <label>{props.label}</label>
      <input  type="TEXT" value={props.value} 
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
      <div>
        <h1>Hello World React {numero}</h1>
        <LabelInput label="RA:" corFundo="#DDDD00" 
                    value={this.state.alunoAtual.ra}
                    atualizarTexto={(txt) => this.atualizarTexto('ra', txt)}/>

        <LabelInput label="Nome:" corFundo="#DDDD00"
                    value={this.state.alunoAtual.nome}
                    atualizarTexto={(txt) => this.atualizarTexto('nome', txt)}/>

        <LabelInput label="Nascimento:" corFundo="#DDDD00"
                    value={this.state.alunoAtual.nascimento}
                    atualizarTexto={(txt) => this.atualizarTexto('nascimento', txt)}/>
        <button onClick={()=>{this.salvar()}}>Salvar</button>
        <TabelaAlunos state={this.state}/>
      </div>
    );
  }
}

export default App;

