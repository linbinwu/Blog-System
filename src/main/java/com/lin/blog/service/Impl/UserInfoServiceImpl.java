package com.lin.blog.service.Impl;

import com.lin.blog.mapper.UserInfoMapper;
import com.lin.blog.model.entity.UserInfo;
import com.lin.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }
}
