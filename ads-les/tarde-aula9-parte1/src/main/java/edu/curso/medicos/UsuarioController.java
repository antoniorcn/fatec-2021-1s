package edu.curso.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTServicos jwtServicos;

    @RequestMapping("/senha/{senha}")
    public String converteSenha(@PathVariable("senha") String senha) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String senhaCrypto = bcrypt.encode(senha);
        System.out.printf("Senha==> %s criptografada==> %s %n", senha, senhaCrypto);
        return senhaCrypto;
    }

    @RequestMapping(value="/login",
            method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuarioCredenciais usuarioCredenciais) throws Exception {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioCredenciais.getUsuario(),
                        usuarioCredenciais.getSenha())
        );
        System.out.println("Login acionado");
        UserDetails u = userDetailsService.loadUserByUsername(usuarioCredenciais.getUsuario());
        System.out.println("Usuario carregado==>" + u.getUsername());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (bcrypt.matches(usuarioCredenciais.getSenha(), u.getPassword())) {
            String token = jwtServicos.gerarToken(u);
            return "{\"token\":\"" + token + "\"}";
        }
        return "{\"erro\":\"Usuário ou senha inválidos\"}";
    }

    @RequestMapping(value="/reset",
    method=RequestMethod.GET)
    public String reset() {
        userDetailsService.reset();
        return "";
    }
}
