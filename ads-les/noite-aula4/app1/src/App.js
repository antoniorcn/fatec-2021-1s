import React from 'react';

const numero = 10;

class TabelaAlunos extends React.Component { 
  state = {
      lista: [
        {ra: "0001", nome: "João Silva", nascimento: "05/08/2000"},
        {ra: "0002", nome: "Maria Silva", nascimento: "09/10/1999"},
        {ra: "0003", nome: "Pedro Alencar", nascimento: "15/03/2001"},
        {ra: "0004", nome: "João Alencar", nascimento: "22/03/2001"},
      ]
  }

  render() { 
    const listaDisplay = [];
    for (let i = 0; i < this.state.lista.length; i++) { 
      listaDisplay.push(
          <p>{this.state.lista[i].ra} - {this.state.lista[i].nome}</p>
      );
    }
    return (
      <div>
        <h2>Tabela de Alunos</h2>
        {listaDisplay}
        <button onClick={
          ()=>{
            const novoState = {...this.state};
            novoState.lista[0].nome="Aluno Novo";
            this.setState(novoState);
            console.log(this.state.lista);
          }
        }>Alterar</button>
      </div>
    );
  }
}

function LabelInput(props) { 
  return(
    <div style={{backgroundColor: props.corFundo}}>
      <label>{props.label}</label>
      <input type="TEXT"/>
    </div>
  );
}

function App() {
  return (
    <div>
      <h1>Hello World React {numero}</h1>
      <LabelInput label="RA:" corFundo="red"/>
      <LabelInput label="Nome:" corFundo="blue"/>
      <LabelInput label="Nascimento:" corFundo="green"/>
      <button>Carregar</button>
      <TabelaAlunos/>
    </div>
  );
}

export default App;
