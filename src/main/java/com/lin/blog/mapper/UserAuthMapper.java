package com.lin.blog.mapper;

import com.lin.blog.model.entity.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAuthMapper {
    UserAuth getUserAuthByUsername(@Param("username") String username);
}
