package com.yoolean.jblog.service.impl;

import com.yoolean.jblog.dao.UserDetailMapper;
import com.yoolean.jblog.entity.UserDetail;
import com.yoolean.jblog.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    private static final Logger LOG = LoggerFactory.getLogger(AdminUserServiceImpl.class);
    @Resource
    private UserDetailMapper userDetailMapper;

    @Resource
    private JdbcUserDetailsManager userDetailsManager;

    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetail findUserDetail(String username) {
        LOG.info("Get user detail for {}", username);
        UserDetail userDetail = userDetailMapper.selectByUsername(username);
        LOG.debug("User detail for {} is {} ", username, userDetail);
        return userDetail;
    }

    @Override
    public void updatePassword(String username, String originalPassword, String newPassword) {
        LOG.info("Update password for user {}", username);
        userDetailsManager.changePassword(originalPassword, passwordEncoder.encode(newPassword));
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        LOG.info("Update user detail {}", userDetail);
        userDetailMapper.updateUserDetail(userDetail);
    }
}
