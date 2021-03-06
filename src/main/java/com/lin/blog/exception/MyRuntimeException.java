package com.lin.blog.exception;

import com.lin.blog.common.ResultInfo;

public class MyRuntimeException extends RuntimeException {
    private String code;
    private String message;

    public MyRuntimeException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public MyRuntimeException(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
