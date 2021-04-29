package edu.fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepositorio.findByUsuario(username);
        if (u == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UsuarioDetail userDetail = new UsuarioDetail(u);
        return userDetail;
    }
}
