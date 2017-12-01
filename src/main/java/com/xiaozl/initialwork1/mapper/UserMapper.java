package com.xiaozl.initialwork1.mapper;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserMapper {

    public void newUser(@Param("user") User user) throws Exception;

    public int countByUserNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password) throws Exception;
}
