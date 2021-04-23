package com.example.test.designpatterns.responsibilitychain;

/**
 * @Author ： Leo
 * @Date : 2021/4/22 15:13
 * @Desc:
 */
public class CollegeApprover extends Approver {


    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 < purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 10000) {
            System.out.println("请求编号id：" + purchaseRequest.getId() + "被" + this.name + "处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
