package com.example.service.impl;

import com.example.domain.User;
import com.example.dao.UserMapper;
import com.example.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User Sel(int id) {
        return userMapper.Sel(id);
    }
    @Override
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord) ;
    }
    @Override
    public int register(User user) {

        int register = userMapper.register(user);
        return register ;
    }
}
