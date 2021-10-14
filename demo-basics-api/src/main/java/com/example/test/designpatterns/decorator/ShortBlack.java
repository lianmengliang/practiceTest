package com.example.test.designpatterns.decorator;

import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 17:58
 * @Desc:
 */
@Data
public class ShortBlack  extends Coffee{

    public ShortBlack(){
        setDes("shortBlack");
        setPrice(4.0f);
    }
}
