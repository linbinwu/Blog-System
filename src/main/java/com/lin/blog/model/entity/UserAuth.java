package com.lin.blog.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
public class UserAuth implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userInfoId;

    private String username;

    private String password;

    private String ip;

    private Date createTime;

    private Date lastLoginTime;

    public UserAuth() {

    }

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
        this.createTime = new Date();
    }

    public UserAuth(String username, String password, String ip) {
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.createTime = new Date();
        this.lastLoginTime = new Date();
    }
}

