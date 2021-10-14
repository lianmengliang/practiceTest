package com.example.controller;

import com.example.domain.User;
import com.example.enums.testEnum;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ： leo
 * @Date :2019/11/6 15:05
 */
@Api(description = "用户登录注册相关接口", value = "用户登录注册相关接口")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //跳转首页（登录页）

    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    })
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String show() {
        return "index";
    }

    //登录操作
    @ResponseBody
    @RequestMapping("/loginUser")
    public String login(User user, HttpServletRequest request) {
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User loginInfo = userService.login(userName, passWord);
        if (loginInfo == null) {
            return "用户名错误";
        } else {
            //登录成功后将用户放入session中，用于拦截
            request.getSession().setAttribute("session_user", user); //
            System.out.println("欢迎登录////");
        }

        return "登录成功";

    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";

    }

    //注册操作
    @RequestMapping("/register")
    public String register(User user) {
        int register = userService.register(user);
        if (register == 0) {
            System.out.println("--------------");
        }
        return "welcome";

    }


    //测试未登录的拦截页面
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";

    }

    //退出登录
    @RequestMapping("outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }
}
