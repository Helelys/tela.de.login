package com.login.tela.de.login.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Config {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Adicionando usuários com suas credenciais
        manager.createUser(User.withUsername("user")
                .password("{noop}password") // {noop} significa que a senha é sem codificação
                .roles("USER")
                .build());

        manager.createUser(User.withUsername("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN")
                .build());

        return manager;
    }
}
