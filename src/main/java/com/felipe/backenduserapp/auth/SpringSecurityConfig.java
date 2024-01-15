package com.felipe.backenduserapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.felipe.backenduserapp.auth.filters.JwtAuthenticationFilter;
import com.felipe.backenduserapp.auth.filters.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {
     
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }
    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }




    //filtro de seguridad
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET,"/users").permitAll()
        .anyRequest().authenticated() 
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
        .addFilterAfter(new JwtValidationFilter(authenticationConfiguration.getAuthenticationManager()),JwtAuthenticationFilter.class)
        .csrf(config -> config.disable())
        .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }
}
