package edu.fatec;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@ComponentScan
public class JWTFiltro extends GenericFilterBean {

//    @Autowired
//    UsuarioService usuarioService;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest reqhttp = (HttpServletRequest) request;
        System.out.printf("Filtro JWT Path ==>(%s) %n", reqhttp.getServletPath());
        if("/login".equals(reqhttp.getServletPath())) {
            chain.doFilter(request, response);
        } else {
            String authHeader = reqhttp.getHeader("Authorization");
            if (authHeader != null) {
                String token = authHeader.substring(7);
                System.out.printf("Token ==>(%s) %n", token);
                String user = JwtUtil.getAuthentication(token);
//                UserDetails ud = usuarioService.loadUserByUsername(user);
                // if (ud != null) {
                UsernamePasswordAuthenticationToken upAuth =
                        new UsernamePasswordAuthenticationToken(user,
                                null,
                                Collections.singletonList(new SimpleGrantedAuthority("USER")));
                System.out.printf("Authentication Gerado ==>(%s)%n", upAuth);
                if (upAuth != null) {
                    SecurityContextHolder.getContext().setAuthentication(upAuth);
                    System.out.println("Spring Security atualizado");
                    chain.doFilter(request, response);
                }
            }
        }
    }
}
