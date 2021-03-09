package com.lin.blog.security;

import com.lin.blog.model.entity.UserAuth;
import com.lin.blog.model.entity.UserInfo;
import com.lin.blog.service.UserAuthService;
import com.lin.blog.service.UserInfoService;
import com.lin.blog.utils.JsonUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserInfoService userInfoService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        UserAuth user = userAuthService.getUserAuthByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserInfo userInfo = userInfoService.getUserInfoById(user.getUserInfoId());
        //System.out.println(userInfo);
        return User.withUsername(JsonUtils.objectToJson(user)).password("{noop}" + user.getPassword()).roles(userInfo.getRole()).build();
    }
}
