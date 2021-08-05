package com.example.test.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 11:30
 * @Desc:
 */
public class University extends OrganizationComponent {

    private List<OrganizationComponent> list= new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {
        // 获取大学名称
        System.out.println("-----"+getName()+"-----");
        // 下面遍历，打印出各个学院名称
        for (OrganizationComponent organizationComponent : list) {
            organizationComponent.print();
        }
    }


    /**
     * 用于添加学院
     * @param organizationComponent
     */
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }

    /**
     * 用于删除学院
     * @param organizationComponent
     */
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    /**
     * 获取大学名称
     * @return
     */
    @Override
    public String getName() {
        return super.getName();
    }
    /**
     * 获取大学描述
     * @return
     */
    @Override
    public String getDes() {
        return super.getDes();
    }
}
