package com.yoolean.jblog.dao;

import com.yoolean.jblog.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDetailMapper {
    int insertUserDetail(UserDetail userDetail);

    UserDetail selectByUsername(@Param("username") String username);

    void updateUserDetail(UserDetail userDetail);

}