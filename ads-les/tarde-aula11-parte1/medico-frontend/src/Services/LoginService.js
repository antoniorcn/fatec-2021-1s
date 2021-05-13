import axios from "axios";

export default class LoginService { 
    static login(usuario, senha, sucessoCallBack, falhaCallBack) { 
        axios.post('http://localhost:8080/login', 
            {usuario, senha})
        .then((res) => { 
            sucessoCallBack(res.data.token);
        })
        .catch((err) => {
            falhaCallBack(err);
        });
    }
}