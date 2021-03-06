package com.lin.blog.mapper;

import com.lin.blog.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    UserInfo getUserInfoById(@Param("id") Integer id);
}
