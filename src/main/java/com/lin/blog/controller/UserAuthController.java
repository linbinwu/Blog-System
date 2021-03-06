package com.lin.blog.controller;

import com.lin.blog.model.entity.UserAuth;
import com.lin.blog.service.UserAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserAuthController {

    @Resource
    UserAuthService userAuthService;

    @GetMapping("getUserAuth")
    @ResponseBody
    public UserAuth userAuth() {
        return userAuthService.getUserAuthByUsername("admin");
    }
}
