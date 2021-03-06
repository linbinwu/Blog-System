package com.lin.blog.security;

import com.lin.blog.security.Handler.AuthenticationFailureHandlerImpl;
import com.lin.blog.security.Handler.AuthenticationSuccessHandlerImpl;
import com.lin.blog.security.Handler.LogoutSuccessHandlerImpl;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginProcessingUrl("/login").successHandler(authenticationSuccessHandlerImpl).failureHandler(authenticationFailureHandlerImpl).and()
                .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).and()
                .csrf().disable().exceptionHandling();
        http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter = new MyUsernamePasswordAuthenticationFilter();
        myUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandlerImpl);
        myUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandlerImpl);
        myUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return myUsernamePasswordAuthenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
}
