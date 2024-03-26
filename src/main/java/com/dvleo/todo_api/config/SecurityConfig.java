package com.dvleo.todo_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/error").permitAll() // Spring Securityのユーザー認証を無効化するだけなら、この行があればOK（Controllerの作成も不要）
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}
