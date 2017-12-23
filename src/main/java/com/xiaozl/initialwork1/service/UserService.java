package com.xiaozl.initialwork1.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserService {

    public void newUser(@Param("user") User user) throws Exception;

    public boolean checkLogin(User user) throws Exception;

    public List<User> userList()throws  Exception;

    public void insert(User user);
    public void delete(int id);

    public void update(User user);
    public User findById(Integer id);


}
