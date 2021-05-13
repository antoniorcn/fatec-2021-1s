import React from 'react';
import axios from "axios";
import Contexto from '../contexto/ContextoPrincipal';

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

class AlunoApp extends React.Component {
    static contextType = Contexto;
    
    state = {
        alunoAtual: {
        ra: "",
        nome: "",
        nascimento: ""
        },
        lista: []
    }

  componentDidMount() { 
      const cfg = {
        responseType: 'json',
        headers: { 
            authorization: "Bearer " + this.context.token
        }
      }
      axios.get(`http://localhost:8080/alunos`, cfg)
        .then((response) => {
          console.log(response);
          const novoState = {...this.state};
          novoState.lista = response.data;
          this.setState(novoState);
        })
        .catch((err)=> {
            console.log("Erro =>", err);
        })
      console.log("Alunos carregados");
  }

  atualizarTexto(campo, txt) {
    const novoState = {...this.state};
    novoState.alunoAtual[campo] = txt;
    this.setState(novoState);
  }

  salvar() {
    const cfg = {
        headers: { 
            authorization: "Bearer " + this.context.token
        }
    };
    const dados = { 
        id: 0,
        ra: this.state.alunoAtual.ra,
        nome: this.state.alunoAtual.nome,
        nascimento: this.state.alunoAtual.nascimento
    }
    axios.post('http://localhost:8080/aluno/add', dados, cfg)
    .then((response) => {
        console.log("Aluno foi gravado com sucesso");
    })
    .catch((err) => {
        console.log("Erro ao gravar o aluno ", err);
    })
    // const apiUrl = ``;
    //     fetch(apiUrl, {
    //       method: 'POST',
    //       headers: {
    //         Accept: 'text/plain',
    //         'Content-Type': 'application/json'
    //       },
    //       body: JSON.stringify(this.state.alunoAtual)
    //     }).then(
    //       (response)=> {
    //         console.log(response.body);
    //         this.componentDidMount();
    //       }
    //     );
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

export default AlunoApp;

