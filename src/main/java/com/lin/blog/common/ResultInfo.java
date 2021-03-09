package com.lin.blog.common;

public enum ResultInfo {
    LOGIN_SUCCESS("200", "login success"),
    LOGIN_FAIL("403", "login fail"),
    LOGOUT_SUCCESS("200", "logout success"),
    UNAUTHORIZED("401", "unauthorized, please login"),
    ILLEGAL("401", "illegal"),
    SUCCESS("200", "success"),
    NOT_FOUNT("404", "not found"),
    GLOBAL_ERROR("101", "global error");
    private String code;
    private String message;

    ResultInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
