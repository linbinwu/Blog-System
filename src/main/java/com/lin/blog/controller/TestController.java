package com.lin.blog.controller;

import com.lin.blog.common.Result;
import com.lin.blog.common.ResultInfo;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public Result test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AbstractAuthenticationToken test = (AbstractAuthenticationToken) authentication;
        UsernamePasswordAuthenticationToken test2 = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println("details: " + test.getDetails());
        System.out.println("principal: " + test2.getPrincipal());
        return Result.success().codeAndMessage(ResultInfo.SUCCESS);
    }
}