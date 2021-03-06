package com.lin.blog.security;

import com.lin.blog.security.Handler.DefaultAuthenticationFailureHandler;
import com.lin.blog.security.Handler.DefaultAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler;

    @Autowired
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginProcessingUrl("/login");
        http.csrf().disable().exceptionHandling();
        http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter = new MyUsernamePasswordAuthenticationFilter();
        myUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(defaultAuthenticationSuccessHandler);
        myUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(defaultAuthenticationFailureHandler);
        myUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return myUsernamePasswordAuthenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
}
