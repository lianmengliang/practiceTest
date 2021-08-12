package com.example.test.designpatterns.responsibilitychain;

import org.apache.poi.hssf.util.HSSFColor;

/**
 * @Author ： Leo
 * @Date : 2021/4/22 15:26
 * @Desc:
 */
public class ViceSchoolMasterApprover extends Approver {
    public ViceSchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (10000<purchaseRequest.getPrice()   && purchaseRequest.getPrice() <= 30000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
