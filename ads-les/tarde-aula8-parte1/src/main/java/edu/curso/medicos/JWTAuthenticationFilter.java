package edu.curso.medicos;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest) request;
        System.out.printf("ServletRequest ==>(%s)%n", httpreq.getServletPath());
        if ("/login".equals(httpreq.getServletPath())) {
            chain.doFilter(request, response);
        } else {
            String authHeader = httpreq.getHeader("Authorization");
            System.out.printf("Authorization ==>(%s)%n", authHeader);
            if (authHeader != null) {
                String token = authHeader.substring(7);
                System.out.printf("Token ==>(%s)%n", token);
                Authentication auth = JWTServicos.getAuthentication(token);
                System.out.printf("Authentication ==>(%s)%n", auth.getDetails());
                SecurityContextHolder.getContext().setAuthentication(auth);
                chain.doFilter(request, response);
            }
        }
    }
}
