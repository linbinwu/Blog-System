package com.lin.blog.security;

import com.lin.blog.model.entity.UserAuth;
import com.lin.blog.security.support.MyUserDetails;
import com.lin.blog.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userAuthService.getUserAuthByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUserAuth(user);
        myUserDetails.setUsername(user.getUsername());
        myUserDetails.setPassword("{noop}" + user.getPassword());
        return myUserDetails;
    }
}
