package com.example.test.designpatterns.responsibilitychain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ： Leo
 * @Date : 2021/4/20 18:57
 * @Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {

    /**
     *   //请求类型
     */
    private int type = 0;
    /**
     * //请求金额
     */
    private float price = 0.0f;

    private int id = 0;

}
