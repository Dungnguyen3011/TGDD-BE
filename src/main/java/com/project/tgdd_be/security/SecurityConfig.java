package com.project.tgdd_be.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/api/admin/**")
        .authenticated()
        .and()
            .formLogin()
                .defaultSuccessUrl("/api/admin")
                .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/api/home").permitAll()
            .and()
            .csrf().disable();

    }
}
