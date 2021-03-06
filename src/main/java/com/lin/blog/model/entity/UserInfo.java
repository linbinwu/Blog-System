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

    private Integer id;

    private String nickname;

    private String gender;

    private String email;

    private String phone;

    private String avatar;

    private String intro;

    private Date createTime;
}
