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
    /*
     * 主键
     * user_auth_id
     * */
    private Integer id;

    /*
     * 用户信息ID
     * */
    private Integer userInfoId;

    /*
     * 用户账号
     * */
    private String username;

    /*
     * 用户密码
     * */
    private String password;

    /*
     * 用户IP地址
     * */
    private String ip;

    /*
     * 账号创建时间
     * */
    private Date createTime;

    /*
     * 上次登录时间
     * */
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

