import React from 'react';
import axios from 'axios';
import Contexto from '../contexto/ContextoPrincipal';

const URL_BASE = 'http://localhost:8080/';

class Login extends React.Component { 
    static contextType = Contexto;

    state = { 
        username: "",
        password: ""
    }

    setCampo(campo, value) { 
        const novoState = {...this.state};
        novoState[campo] = value;
        this.setState(novoState);
    }

    login() { 
        const dados = {
            usuario: this.state.username,
            senha: this.state.password,
        };
        axios.post(URL_BASE + 'login', dados)
        .then( (response) => {
            // console.log("Resposta ==>", response);
            const token = response.data.token;
            console.log("Token =>", token);
            this.context.setToken(token);
            this.props.history.push('/aluno');
        })
        .catch( (err) => {
            console.log("Erro =>", err)
        });
        
    }

    render() { 
        return (
            <div className="container">
                <h1>Login</h1>
                <form>
                    <div className="form-group">
                        <label>Username</label>
                        <input  type="text" className="form-control" 
                                value={this.state.username}
                                onChange={(e)=>{this.setCampo('username', e.target.value)}}/>
                    </div>
                    <div className="form-group">
                        <label>Password</label>
                        <input type="password" className="form-control" 
                               value={this.state.password}
                               onChange={(e)=>{this.setCampo('password', e.target.value)}}/>
                    </div>
                    <div className="form-group">
                        <button type="button" className="btn btn-primary"
                        onClick={()=>{this.login()}}>Login</button>
                    </div>
                </form>
            </div>
        );
    }
     // setUsername(novoUsername) { 
    //     const novoState = {...this.state};
    //     novoState.username = novoUsername;
    //     this.setState(novoState);
    // }

    // setPassword(novoPassword) { 
    //     const novoState = {...this.state};
    //     novoState.password = novoPassword;
    //     this.setState(novoState);
    // }
}
export default Login;