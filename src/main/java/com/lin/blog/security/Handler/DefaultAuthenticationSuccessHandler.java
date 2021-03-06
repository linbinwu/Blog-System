package com.lin.blog.security.Handler;

import com.lin.blog.common.Result;
import com.lin.blog.common.ResultInfo;
import com.lin.blog.utils.JsonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.getWriter().write(
                JsonUtils.objectToJson(Result.success()
                .codeAndMessage(ResultInfo.SUCCESS))
        );
    }
}
