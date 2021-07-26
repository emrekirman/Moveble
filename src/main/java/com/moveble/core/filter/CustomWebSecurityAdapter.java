package com.moveble.core.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/")
                .antMatchers("/favicon.ico")
                .antMatchers("/swagger-ui/**")
                .antMatchers("/v3/api-docs/**")
                .antMatchers("/api/auth/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class)
                .csrf().disable();
    }
}