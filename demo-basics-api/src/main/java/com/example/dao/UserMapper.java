package com.example.dao;

import com.example.domain.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:48
 */
public interface UserMapper extends Mapper<User> {

    User Sel(int id);

    User login(String userName, String passWord);

    int register(User user);


}
