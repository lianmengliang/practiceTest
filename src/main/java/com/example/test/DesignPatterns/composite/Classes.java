package com.example.test.DesignPatterns.composite;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 12:14
 * @Desc:
 */
public class Classes extends OrganizationComponent{

    /**
     * 构造器
     * @param name
     * @param des
     */
    public Classes(String name, String des) {
        super(name, des);
    }

    /**
     * 由于班级是子节点，就不再重写add和remove 方法了
     */
    @Override
    protected void print() {
        System.out.println(getName());
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
