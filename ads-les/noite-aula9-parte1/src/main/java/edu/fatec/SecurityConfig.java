package edu.fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(usuarioService)
                    .passwordEncoder(getPasswordEncoder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()
            .authorizeRequests()
                .antMatchers("/senha/**").anonymous()
                .antMatchers("/login/**").anonymous()
            .antMatchers("/alunos/**").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/aluno/add/**").hasAuthority("ADMIN")
            .antMatchers("/**").denyAll()
                .and()
                .addFilterBefore(new JWTFiltro(), UsernamePasswordAuthenticationFilter.class)
              .csrf().disable()
            .formLogin().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        // return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner inicio(ApplicationContext ctx) {
        System.out.println("Beans disponíveis ---->");
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                String[] beans = ctx.getBeanDefinitionNames();
                for(String bean :beans) {
                    System.out.println(bean);
                }
            }
        };
    }
}
