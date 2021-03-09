package com.lin.blog.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
    * 主键
    * user_info_id
    * */
    private Integer id;

    /*
    * 用户角色
    * */
    private String role;

    /*
    * 昵称
    * */
    private String nickname;

    /*
    * 性别
    * */
    private String gender;

    /*
    * 邮箱
    * */
    private String email;

    /*
    * 手机号码
    * */
    private String phone;

    /*
    * 头像地址
    * */
    private String avatar;

    /*
    * 简介
    * */
    private String intro;

    /*
    * 创建时间
    * */
    private Date createTime;
}
