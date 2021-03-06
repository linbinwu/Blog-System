package com.lin.blog.service.Impl;

import com.lin.blog.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl {
    @Autowired
    UserInfoMapper userInfoMapper;
}
