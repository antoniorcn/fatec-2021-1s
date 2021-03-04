import React from 'react';

const numero = 10;

class TabelaAlunos extends React.Component { 

  lista = [
    {ra: "0001", nome: "João Silva", nascimento: "05/08/2000"},
    {ra: "0002", nome: "Maria Silva", nascimento: "09/10/1999"},
    {ra: "0003", nome: "Pedro Alencar", nascimento: "15/03/2001"},
  ];

  render() { 
    return (
      <h2>Tabela de Alunos</h2>
      
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
