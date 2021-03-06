package com.lin.blog.controller;

import com.lin.blog.service.UserInfoService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;
}
