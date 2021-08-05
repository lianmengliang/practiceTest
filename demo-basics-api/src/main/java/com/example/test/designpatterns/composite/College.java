package com.example.test.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 11:34
 * @Desc:
 */
public class College extends OrganizationComponent {

    // list中用来存放Department
    private List<OrganizationComponent> list= new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    /**
     * print方法，就是输出University包含的学院
     */
    @Override
    protected void print() {
        // getName() 获取的是学院名称
        System.out.println("---"+getName()+"---");
        // 下面遍历学院名称
        for (OrganizationComponent organizationComponent : list) {
//            System.out.println(organizationComponent);
            organizationComponent.print();
        }
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        // 将来实际业务中的College的add 和 University的add不一定完全一样
        list.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }
}
