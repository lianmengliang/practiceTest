package com.example.controller;

import com.example.response.CommonResult;
import com.example.service.WithdrawAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ： leo
 * @Date :2020/6/17 16:05
 */
@RequestMapping(value = "withdraw/account")
@RestController
@Api(value = "提现账户管理")
public class WithdrawAccountController {



    @Autowired
    private WithdrawAccountService accountService ;



    @GetMapping("/query")
    @ApiOperation(value = "账户余额查询")
    public CommonResult queryAccountBanlance(){

        CommonResult commonResult = accountService.queryAccountBalance();


        return commonResult;
    }
}
