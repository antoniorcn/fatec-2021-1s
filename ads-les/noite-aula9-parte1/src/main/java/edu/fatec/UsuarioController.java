package edu.fatec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(
            method = RequestMethod.GET,
            value="/senha/{senha}")
    public String codificaSenha(@PathVariable("senha") String senha) {
        String senhaCrypto = passwordEncoder.encode(senha);
        return senhaCrypto;
    }

    @RequestMapping(
            value="/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuarioCredenciais usuarioCredenciais) {
        UserDetails ud = usuarioService.loadUserByUsername(usuarioCredenciais.getUsuario());
        if (ud != null
                && passwordEncoder.matches(ud.getPassword(), usuarioCredenciais.getSenha())) {

            return "{\"token\":\"" + JwtUtil.generateToken(ud.getUsername()) + "\"}";
        } else {
            return "{\"erro\":\"Usuário ou senha inválidos\"}";
        }
    }
}
