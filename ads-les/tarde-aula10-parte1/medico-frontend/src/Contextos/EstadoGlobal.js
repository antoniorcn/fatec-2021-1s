import React from "react";
import ContextoPrincipal from "./ContextoPrincipal";

export default class EstadoGlobal extends React.Component { 

    state = { 
        token : ""
    }

    atualizarToken = (token) => { 
        const novoState = {...this.state};
        novoState.token = token;
        this.setState(novoState); 
    }

    render() { 
        return (
            <ContextoPrincipal.Provider 
                value={{
                    token: this.state.token,
                    atualizarToken: this.atualizarToken,
                }}>
                {this.props.children}
            </ContextoPrincipal.Provider>
        );
    }
}