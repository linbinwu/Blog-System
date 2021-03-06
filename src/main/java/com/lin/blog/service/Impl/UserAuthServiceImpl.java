package com.lin.blog.service.Impl;

import com.lin.blog.mapper.UserAuthMapper;
import com.lin.blog.model.entity.UserAuth;
import com.lin.blog.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    UserAuthMapper userAuthMapper;

    @Override
    public UserAuth getUserAuthByUsername(String username) {
        return userAuthMapper.getUserAuthByUsername(username);
    }
}
