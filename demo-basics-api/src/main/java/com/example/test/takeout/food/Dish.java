package com.example.test.takeout.food;

import lombok.Data;

import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/8/16 14:10
 * @Desc:
 */
@Data
public class Dish extends Season{
    /**
     * 菜名
     */
    private String name;

    /**
     * 食材
     */
    private List<Ingredient> ingredients;

    /**
     * 销售价格
     */
    private double price;

}
