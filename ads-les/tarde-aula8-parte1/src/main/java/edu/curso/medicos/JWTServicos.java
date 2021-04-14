package edu.curso.medicos;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Date;

public class JWTServicos {

    private static final String JWT_SECRET = "FATEC 2021-1S CHAVE";

    public static String gerarToken(UsuarioCredenciais usuarioCredenciais) {
        String token = Jwts.builder()
                .setSubject(usuarioCredenciais.getUsuario())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();

        return token;
    }

    public static Authentication getAuthentication(String token) {
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            System.out.printf("User ==>(%s)%n", user);
            if (user != null) {
                UsernamePasswordAuthenticationToken upauth =
                        new UsernamePasswordAuthenticationToken(user, null,
                                Collections.singletonList(new SimpleGrantedAuthority("USER")));
                System.out.printf("UsernamePasswordAuthenticationToken ==>(%s)%n", upauth);
                return upauth;
            }
        }
        return null;
    }
}
