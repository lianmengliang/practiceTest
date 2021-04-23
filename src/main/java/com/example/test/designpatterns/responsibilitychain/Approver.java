package com.example.test.designpatterns.responsibilitychain;

import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/4/20 18:58
 * @Desc:
 */
@Data
public abstract class Approver {
    /**
     * 下一个处理者
     */
    Approver approver;
    /**
     * 名字
     */
    String name;

    public Approver(String name) {
        this.name = name;
    }



    /**
     * 处理审批请求的方法，得到一个请求, 处理是子类完成，因此该方法做成抽象
     * @param purchaseRequest
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
