package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ： leo
 * @Date :2020/7/20 11:55
 */
@Data
public class Company implements Serializable {


    private Integer id;

    private String department;

    private String name;

    private Integer age ;
}
