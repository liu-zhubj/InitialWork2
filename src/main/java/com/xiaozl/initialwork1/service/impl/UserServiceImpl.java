package com.xiaozl.initialwork1.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.mapper.UserMapper;
import com.xiaozl.initialwork1.service.UserService;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void newUser(@Param("user") User user) throws Exception {
        if (user == null) {
            return ;
        }

        try {
            user.setPassword(user.getPassword());
            userMapper.newUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean checkLogin(User user) throws Exception {
        if (user == null) {
            return false;
        }

        try {
            return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
