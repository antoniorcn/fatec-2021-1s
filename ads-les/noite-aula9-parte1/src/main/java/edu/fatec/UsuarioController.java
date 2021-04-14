package edu.fatec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UsuarioController {

    private final static long EXPIRATION = 1000 * 60 * 60 * 10;
    private final static String SECRET = "Fatec Secret";
    @Autowired
    PasswordEncoder passwordEncoder;

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
        String token = Jwts.builder()
                .setSubject(usuarioCredenciais.getUsuario())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "{\"token\":\"" + token + "\"}";
    }
}
