package com.example.test.DesignPatterns.iterator;

import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 11:56
 * @Desc:
 */
@Data
public class Department {
    private String name;
    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
