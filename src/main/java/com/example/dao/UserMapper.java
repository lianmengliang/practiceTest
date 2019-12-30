package com.example.dao;

import com.example.domain.User;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:48
 */
public interface UserMapper {

    User Sel(int id);

    User login(String userName, String passWord);

    int register(User user);


}
