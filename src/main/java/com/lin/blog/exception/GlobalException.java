package com.lin.blog.exception;

import com.lin.blog.common.Result;
import com.lin.blog.common.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.fail().codeAndMessage(ResultInfo.GLOBAL_ERROR);
    }

    @ExceptionHandler(MyRuntimeException.class)
    @ResponseBody
    public Result myRuntimeException(MyRuntimeException e) {
        e.printStackTrace();
        return Result.fail().codeAndMessage(e.getCode(), e.getMessage());
    }

}
