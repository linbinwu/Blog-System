package com.lin.blog.common;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private boolean status; // 请求状态
    private String code; // 状态码
    private String message; // 数据
    Map<String, Object> data = new HashMap<>();

    public Result() {
    }

    public Result(boolean status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        Result result = new Result();
        result.status = true;
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.status = false;
        return result;
    }

    public Result code(String code) {
        this.setCode(code);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result codeAndMessage(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result codeAndMessage(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

