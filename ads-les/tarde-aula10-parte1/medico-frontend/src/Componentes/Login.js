import React from "react";
import ContextoPrincipal from "../Contextos/EstadoGlobal";
import LoginService from "../Services/LoginService";

class Login extends React.Component { 
    static contextType = ContextoPrincipal;
    // constructor(props) { 
    //     super(props);
    //     this.logar.bind(this);
    // }

    state = { 
        usuario: "",
        senha: "",
    }

    atualizarState(campo, novoTexto) { 
        const novoState = {...this.state};
        novoState[campo] = novoTexto;
        this.setState(novoState);
    }

    logar() { 
        console.log("Login");
        console.log("Usuario ==> ", this.state.usuario);
        console.log("Senha ==> ", this.state.senha);
        this.context.atualizarToken("TOKEN NOVO");
        this.props.history.push('/');
        // LoginService.login(
        //     this.state.usuario, 
        //     this.state.senha,
        //     (tkn) => {
        //         console.log("Login ocorrido com sucesso");
        //         this.context.atualizarToken(tkn);
        //         // this.props.history.push('/');
        //     },
        //     () => {
        //         console.log("Usuário ou senha incorretos");
        //     });
    }

    render() { 

        return (
            <div>
                <p>Login</p>
                <p>Token -- {this.context.token}</p>
                <div className="form-group">
                    <label>Usuario: </label>
                    <input  type="TEXT" value={this.state.usuario} 
                        placeholder="Informe o nome do usuario"
                        className="form-control"
                        onChange={(novoTexto)=>{
                            this.atualizarState('usuario', novoTexto.target.value);
                        }}/>
                
                </div>
                <div className="form-group">
                    <label>Senha: </label>
                    <input  type="PASSWORD" value={this.state.senha}
                            placeholder="Informe a senha de acesso"
                            className="form-control"
                            onChange={(novoTexto)=>{
                                this.atualizarState('senha', novoTexto.target.value);
                            }}/>
                </div>
                <button className="btn btn-primary"
                        onClick={() => {
                            this.logar();
                        }}>Login</button>
            </div>
        );
    }
}

export default Login;