package com.example.test.designpatterns.responsibilitychain;

/**
 * @Author ： Leo
 * @Date : 2021/4/22 15:19
 * @Desc:
 */
public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号id："+purchaseRequest.getId()+"被"+this.name+"处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
