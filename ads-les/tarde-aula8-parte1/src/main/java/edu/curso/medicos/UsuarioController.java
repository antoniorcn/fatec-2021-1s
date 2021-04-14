package edu.curso.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

//    @Autowired
//    AuthenticationManager authManager;

    @RequestMapping("/senha/{senha}")
    public String converteSenha(@PathVariable("senha") String senha) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String senhaCrypto = bcrypt.encode(senha);
        System.out.printf("Senha==> %s criptografada==> %s %n", senha, senhaCrypto);
        return senhaCrypto;
    }

    @RequestMapping(value="/login",
            method=RequestMethod.POST)
    public String adicionar(@RequestBody UsuarioCredenciais usuarioCredenciais) {
        try {

//            authManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            usuarioCredenciais.getUsuario(),
//                            usuarioCredenciais.getSenha(),
//                            Collections.emptyList()
//                    ));

            UserDetails u = userDetailsService.loadUserByUsername(usuarioCredenciais.getUsuario());
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            if (bcrypt.matches(usuarioCredenciais.getSenha(), u.getPassword())) {
                String token = JWTServicos.gerarToken(usuarioCredenciais);

                return "{\"token\":\"" + token + "\"}";
            }
        } catch (Exception e) {
            System.out.println("Usuário ou senha inválido");
            e.printStackTrace();
        }
        return "{\"erro\":\"Usuário ou senha inválidos\"}";
    }

}
