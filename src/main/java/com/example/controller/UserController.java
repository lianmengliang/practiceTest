package com.example.controller;

import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:44
 */
@Api(description = "用户管理相关接口" ,value = "用户管理相关接口")
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户id查询用户信息")
    @RequestMapping(value = "/get/{id}")
    public String getUser(@PathVariable int id) {
        return userService.Sel(id).toString();
    }

    @ApiOperation("欢迎信息")
    @RequestMapping("/hello")
    public String getUser() {
        return "Welcome to Springboot! ";
    }


}
