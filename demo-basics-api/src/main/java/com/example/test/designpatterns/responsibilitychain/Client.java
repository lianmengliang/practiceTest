package com.example.test.designpatterns.responsibilitychain;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {


        // 创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 130000, 1);

        // 创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover schoolMasterApprover = new ViceSchoolMasterApprover("王副校");
        SchoolMasterApprover masterApprover = new SchoolMasterApprover("连校长");

        // 需要将各个审批级别的下一个设置好（处理人构成环形）
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(masterApprover);
        masterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);
        /*collegeApprover.processRequest(purchaseRequest);
        schoolMasterApprover.processRequest(purchaseRequest);
        masterApprover.processRequest(purchaseRequest);*/

    }
}
