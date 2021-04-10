package com.lonelydutchhound.adoptation.configuration;

import com.lonelydutchhound.adoptation.repository.PrincipalRepository;
import com.lonelydutchhound.adoptation.repository.PrincipalRoleRepository;
import com.lonelydutchhound.adoptation.repository.RoleRepository;
import com.lonelydutchhound.adoptation.security.DBUserService;
import com.lonelydutchhound.adoptation.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalRepository principalRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrincipalRoleRepository principalRoleRepository;

    @Override
    protected UserDetailsService userDetailsService() {
        return new DBUserService(principalRepository, principalRoleRepository, roleRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthService authService() {
        return new AuthService(principalRepository, roleRepository, principalRoleRepository, passwordEncoder());
    }
}
