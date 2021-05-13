import axios from "axios";
import React from "react";
import Contexto from "../Contextos/ContextoPrincipal";

class CorpoMedico extends React.Component { 
    static contextType = Contexto;
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
      const opts = {
        headers: { 
          authorization: "Bearer " + this.context.token
        }
      }
      const apiUrl = `http://localhost:8080/medico/add`;
      axios.post(apiUrl, this.state.medicoAtual, opts)
      .then(
            (response)=> {
              console.log(response.body);
              this.carregarMedicos(); })
      .catch( (err) => { 
        console.log(err);
      });
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
      const novoState = {...this.state};
      novoState.lista[0].nome = "Dr. Dolitle";
      this.setState(novoState);
    }
  
    carregarMedicos() { 
      const opts = {
        responseType: 'json',
        headers: { 
          authorization: "Bearer " + this.context.token
        }
      }
      axios.get(`http://localhost:8080/medicos`, opts)
      .then(
        (response) => {
          const novoState = {...this.state};
          novoState.lista = response.data;
          this.setState(novoState);
        })
      .catch( (err) => { 
        console.log(err);
      });
      console.log("Medicos carregados");
    }
  }

  export default CorpoMedico;