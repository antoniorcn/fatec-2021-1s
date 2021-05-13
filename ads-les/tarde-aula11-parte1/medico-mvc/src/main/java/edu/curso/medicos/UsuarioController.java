package edu.curso.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTServicos jwtServicos;

    @RequestMapping("/senha/{senha}")
    public String converteSenha(@PathVariable("senha") String senha) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String senhaCrypto = bcrypt.encode(senha);
        System.out.printf("Senha==> %s criptografada==> %s %n", senha, senhaCrypto);
        return senhaCrypto;
    }

    @RequestMapping(value="/login",
            method=RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView("login");
        System.out.println("Login acionado");

        List<String> lista = Arrays.asList("João", "Maria", "Antonio", "Sara", "Charles", "Juliana");

        mv.addObject("nome", "Antonio");
        mv.addObject("numero", 102030);
        mv.addObject("lista", lista);

        return mv;
    }
}
