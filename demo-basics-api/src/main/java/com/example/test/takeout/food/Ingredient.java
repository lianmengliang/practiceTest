package com.example.test.takeout.food;

import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/8/16 12:30
 * @Desc:  食材
 */
@Data
public class Ingredient {

     private String name;

    /**
     * 成本价
     */
    private double costPrice;

}
