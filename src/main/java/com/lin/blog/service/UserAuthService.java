package com.lin.blog.service;

import com.lin.blog.model.entity.UserAuth;

public interface UserAuthService {
    UserAuth getUserAuthByUsername(String username);
}
