package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.config;


import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service.UserDetailServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    private UserDetailServiceImp userDetailServiceImp;

    public SecurityConfig(UserDetailServiceImp userDetailServiceImp) {
        this.userDetailServiceImp = userDetailServiceImp;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity
                .csrf()
                .disable();
        httpSecurity.authorizeHttpRequests((auth)->auth
                .requestMatchers("/auth/**").permitAll()

                .requestMatchers("/show").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("userpass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminpass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,admin);
    }*/


}