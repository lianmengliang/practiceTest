package com.example.domain;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "student")
public class Student implements Serializable {
    /**
     * 用户id
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;


    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 数学分数
     */
    @Column(name = "math")
    private Integer math;

    /**
     * 英语分数
     */
    @Column(name = "english")
    private Integer english;
}