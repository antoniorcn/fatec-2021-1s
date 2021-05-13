package edu.curso.medicos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailImpl implements UserDetails {

    private Usuario usuario;

    public UserDetailImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        GrantedAuthority ga = new SimpleGrantedAuthority(usuario.getPerfil());
//        List<GrantedAuthority> lista = new ArrayList<>();
//        return lista;
        return Collections.singletonList(new SimpleGrantedAuthority(usuario.getPerfil()));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
