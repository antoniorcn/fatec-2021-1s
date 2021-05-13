package edu.curso.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Procurando pelo usuario=> " + username);
        Usuario u = usuarioRepository.findByUsuario(username);

        if (u == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UserDetailImpl ud = new UserDetailImpl(u);
        System.out.println("Usuario encontrado => " + ud.getUsername() + " senha ==> " + ud.getPassword() + "  autoridade ==>" + ud.getAuthorities().toString());
        return ud;
    }

    public void reset() {
        // usuarioRepository
    }
}
