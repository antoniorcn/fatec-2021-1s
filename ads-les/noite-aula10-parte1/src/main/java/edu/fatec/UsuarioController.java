package edu.fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(
            method = RequestMethod.GET,
            value="/senha/{senha}")
    public String codificaSenha(@PathVariable("senha") String senha) {
        String senhaCrypto = passwordEncoder.encode(senha);
        return senhaCrypto;
    }

    @RequestMapping(
            value = "/login",   method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuarioCredenciais usuarioCredenciais) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioCredenciais.getUsuario(),
                        usuarioCredenciais.getSenha())
        );
        final UserDetails userDetails = usuarioService
                .loadUserByUsername(usuarioCredenciais.getUsuario());
        final String token = jwtUtil.generateToken(userDetails);
        return "{\"token\":\"" + token + "\"}";
    }

}
