package com.yoolean.jblog.service;

import com.yoolean.jblog.entity.UserDetail;

public interface AdminUserService {

    UserDetail findUserDetail(String username);

    void updatePassword(String username, String originalPassword, String newPassword);

    void updateUserDetail(UserDetail userDetail);

}
