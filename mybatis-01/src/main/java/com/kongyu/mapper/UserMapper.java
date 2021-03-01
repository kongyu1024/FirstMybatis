package com.kongyu.mapper;

import java.util.List;

import com.kongyu.pojo.User;

/**
 * @Author kongyu
 * @create 2021/3/1 16:09
 */
public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    void addUser(User user);

    int updateUser(User user);

}
