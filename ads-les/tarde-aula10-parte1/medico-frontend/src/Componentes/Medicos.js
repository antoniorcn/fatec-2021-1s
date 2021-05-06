import axios from "axios";
import React from "react";
import ContextoPrincipal from "../Contextos/ContextoPrincipal";

class CorpoMedico extends React.Component { 
    state = { 
      medicoAtual : {
        nome : "",
        crm : "",
        especialidade: ""
      },
      
      lista: [
      ],
    }
  
    inputChange(campo, novoTexto) { 
      const novoState = {...this.state};
      novoState.medicoAtual[campo] = novoTexto;
      this.setState(novoState);
    }
   
    adicionar() { 
      const apiUrl = `http://localhost:8080/tarde-aula1/medico`;
          fetch(apiUrl, {
            method: 'POST',
            headers: {
              Accept: 'text/plain',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state.medicoAtual)
          }).then(
            (response)=> {
              console.log(response.body);
              this.carregarMedicos();
            }
          );
    }
  
    render() { 
      const displayLista = [];
  
      for (let i = 0; i < this.state.lista.length; i++) { 
        displayLista.push(
          <tr key={i}>
            <td>{this.state.lista[i].crm}</td>
            <td>{this.state.lista[i].nome}</td>
            <td>{this.state.lista[i].especialidade}</td>
          </tr>);
      }    
      
      return (
        <div>
          <p>Dados do Médico</p>
          <p>Token = {this.context.token}</p>
          <div className="form-group">
            <label>CRM: </label>
            <input  type="TEXT" value={this.state.medicoAtual.crm} 
                    placeholder="Digite o CRM do medico"
                    className="form-control"
                    onChange={(novoTexto)=>{this.inputChange('crm', novoTexto.target.value)}}/>
            
          </div>
          <div className="form-group">
            <label>Nome: </label>
            <input  type="TEXT" value={this.state.medicoAtual.nome} 
                    placeholder="Digite o nome do medico"
                    className="form-control"
                    onChange={(novoTexto)=>{this.inputChange('nome', novoTexto.target.value)}}/>
          </div>
          <div className="form-group">
            <label>Especialidade: </label>
            <input  type="TEXT" value={this.state.medicoAtual.especialidade} 
                    placeholder="Digite a especialidade do medico"
                    className="form-control"
                    onChange={(novoTexto)=>{this.inputChange('especialidade', novoTexto.target.value)}}/>                           
          </div>
          <button className="btn btn-primary" onClick={()=>{this.adicionar()}}>Adicionar</button>
          <p>Médicos Cadastrados</p>
          <table className="table table-striped">
            <thead>
              <tr>
                <th>CRM</th>
                <th>Nome</th>
                <th>Especialidade</th>
              </tr>
            </thead>
            <tbody>
              {displayLista}
            </tbody>
          </table>
          <button className="btn btn-primary" onClick={() => {this.carregarMedicos()}}>Recarregar Medicos</button>
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
      console.log("Medicos carregados");
    }
  }

  CorpoMedico.contextType = ContextoPrincipal;

  export default CorpoMedico;