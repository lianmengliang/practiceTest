package com.example.practice.model;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @Author ： leo
 * @Date :2020/4/26 14:50
 */
@Data
public class ScoreInfo {

    private String name;

    private Integer chinese;

    private Integer math;

    private Integer english;

    public ScoreInfo(String name, Integer chinese, Integer math, Integer english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public ScoreInfo() {

    }
}
