import axios from "axios";

function botao() { 
  return (
    <button onClick={medicos}>Salvar</button>
  );
}

function cabecalho() { 
  return (
    <p>Bem vindo ao sistema</p>
  );
}


function medicos() { 
  axios.get(
    `http://localhost:8080/tarde-aula1/medico`,
      {
        responseType: 'json',
      }
    ).then(
    (response) => {
      console.log(response.data);
    }
  );
  console.log("Medico acionado");
}


function retornaPagina() { 
  return (
    <div>
      {cabecalho()}
      <p>Paragrafo 1</p>
      {botao()}
    </div>
  );
}


export default retornaPagina;