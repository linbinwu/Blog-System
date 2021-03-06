package com.lin.blog.security.Handler;

import com.lin.blog.common.Result;
import com.lin.blog.common.ResultInfo;
import com.lin.blog.utils.JsonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.getWriter().write(
                JsonUtils.objectToJson(Result.fail()
                        .codeAndMessage(ResultInfo.NOT_FOUNT)
                        .data("AuthenticationException", "Failure"))
        );
    }
}
