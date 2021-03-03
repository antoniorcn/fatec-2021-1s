import axios from "axios";
import React from "react";

function cabecalho() { 
  return (
    <p>Bem vindo ao sistema</p>
  );
}

class CorpoMedico extends React.Component { 
  state = { 
    lista: [
    ],
  }

  render() { 
    const displayLista = [];

    for (let i = 0; i < this.state.lista.length; i++) { 
      displayLista.push(
        <p key={i}>{this.state.lista[i].nome} - {this.state.lista[i].especialidade}</p>);
    }    
    
    return (
      <div>
        <p>Nome dos médicos</p>
        {displayLista}
        {this.botaoAlterar()}
      </div>
    );
  }

  alterarNomesMedicos() { 
    // const novoState = {};
    // novoState.lista = this.state.lista;
    
    // const novoState = Object.assign({}, this.state);

    const novoState = {...this.state};
    novoState.lista[0].nome = "Dr. Dolitle";
    this.setState(novoState);
  }

  botaoAlterar() { 
    return (
      <button onClick={() => {this.carregarMedicos()}}>Carregar</button>
    );
  } 

  carregarMedicos() { 
    axios.get(
      `http://localhost:8080/tarde-aula1/medico`,
        {
          responseType: 'json',
        }
      ).then(
      (response) => {
        const novoState = {...this.state};
        novoState.lista = response.data;
        this.setState(novoState);
      }
    );
    console.log("Medico acionado");
  }
}




function retornaPagina() { 
  return (
    <div>
      {cabecalho()}
      <CorpoMedico/>
    </div>
  );
}


export default retornaPagina;