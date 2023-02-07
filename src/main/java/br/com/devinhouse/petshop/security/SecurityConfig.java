package br.com.devinhouse.petshop.security;

import br.com.devinhouse.petshop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioService service;

    // Aqui acontece o filter (regras de negócio)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((auth) ->
                        auth.anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

    public void configureGlobal(AuthenticationManagerBuilder) {
        auth.userDetailsService(service)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
