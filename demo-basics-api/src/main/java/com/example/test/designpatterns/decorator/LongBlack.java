package com.example.test.designpatterns.decorator;

import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 17:56
 * @Desc:
 */
@Data
public class LongBlack extends Coffee {
    public LongBlack() {
        setDes("美式咖啡");
        setPrice(5.0f);
    }
}
