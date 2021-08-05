package com.example.test.designpatterns.composite;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 11:22
 * @Desc:
 */
public abstract class OrganizationComponent {

    private String name;

    private String des;

    protected void add(OrganizationComponent organizationComponent){
      throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    // 打印方法
    protected abstract void print();

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
