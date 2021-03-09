package com.lin.blog.security;

import com.lin.blog.security.Handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandler;
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginProcessingUrl("/login").successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
                .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).and()
                .authorizeRequests()
                //开放测试账号权限
                .antMatchers(HttpMethod.GET,"/admin/**").hasAnyRole("test","admin")
                //管理员页面需要权限
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers(HttpMethod.GET,"/comments").permitAll()
                //用户操作，发表评论需要登录
                .antMatchers("/users/info","/users/avatar","/comments").authenticated()
                .anyRequest().permitAll()
                .and()
                //关闭跨站请求防护
                .csrf().disable().exceptionHandling()
                //未登录处理
                //.authenticationEntryPoint(authenticationEntryPoint)
                //权限不足处理
                .accessDeniedHandler(accessDeniedHandler).and()
                //开启嵌入
                .headers().frameOptions().disable();
    }

}
