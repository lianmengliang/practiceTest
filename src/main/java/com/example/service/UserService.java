package com.example.service;

import com.example.domain.User;

/**
 * @Author ： leo
 * @Date :2019/11/7 14:54
 */
public interface UserService {

    User Sel(int id);

    User login(String userName, String passWord);

    int register(User user);
}
