package com.example.test.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 11:36
 * @Desc:
 */
public class Department extends OrganizationComponent {

    private List<OrganizationComponent> list= new ArrayList<>();
    /**
     * 构造器
     * @param name
     * @param des
     */
    public Department(String name, String des) {
        super(name, des);
    }

    /**
     * add,remove 就不需要再写了， 因为它是叶子节点
     */
    @Override
    protected void print() {
        System.out.println("--"+getName()+"--");
        for (OrganizationComponent organizationComponent : list) {
            organizationComponent.print();
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }


    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }
}
