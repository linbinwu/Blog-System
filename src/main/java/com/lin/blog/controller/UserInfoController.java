package com.lin.blog.controller;

import com.lin.blog.model.entity.UserInfo;
import com.lin.blog.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;


    @GetMapping("getUserInfo")
    @ResponseBody
    public UserInfo userInfo() {
        return userInfoService.getUserInfoById(1);
    }
}
