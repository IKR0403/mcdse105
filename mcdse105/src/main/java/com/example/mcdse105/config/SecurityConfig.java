package com.example.mcdse105.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.mcdse105.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        
        return auth;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/assets/**").permitAll()
                .antMatchers(HttpMethod.GET, "/products").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/productview").hasAnyAuthority("USER") 
                .antMatchers(HttpMethod.GET, "/about").permitAll()
                .antMatchers(HttpMethod.GET, "/contact").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/register").permitAll()
                .antMatchers(HttpMethod.POST, "/register").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .defaultSuccessUrl("/productsProcces")
                .permitAll()
                .and()
            .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll();
                
        
        return http.build();
    }
    
    @Bean
    public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
        http
            .csrf().disable();
        return http.build();
    }
}
