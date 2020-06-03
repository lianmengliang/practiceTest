package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:41
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;


}
