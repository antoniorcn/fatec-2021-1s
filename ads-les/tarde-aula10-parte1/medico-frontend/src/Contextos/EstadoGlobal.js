import React from "react";

const ContextoPrincipal = React.createContext(
    {
        token: "",
        atualizarToken: () => {},
    }
);

export class EstadoGlobal extends React.Component { 

    state = { 
        token : "teste token"
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

export default ContextoPrincipal;