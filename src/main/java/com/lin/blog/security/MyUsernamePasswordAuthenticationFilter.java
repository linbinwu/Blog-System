package com.lin.blog.security;

import com.lin.blog.utils.GetRequestJsonUtils;
import com.lin.blog.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //json
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            if (!request.getMethod().equals("POST")) {
                throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
            }
            Map<String, String> map = new HashMap<>();
            try {
                map = JsonUtils.jsonToObject(GetRequestJsonUtils.getRequestPostStr(request), Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (map != null) {
                String username = map.get("username");
                username = username != null ? username : "";
                String password = map.get("password");
                password = password != null ? password : "";
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
            else {
                throw new AuthenticationServiceException("No User in request");
            }

        }

        return super.attemptAuthentication(request, response);
    }
}
