package com.example.test.DesignPatterns.prototype.deepclone;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 17:00
 * @Desc:
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {

        DeepProtoType p = new DeepProtoType();
        p.name = "林冲";
        p.deepCloneableTarget = new DeepCloneableTarget("大明", "明类");

        // 方式1：完成深拷贝

        DeepProtoType p2 = (DeepProtoType) p.clone();
        System.out.println("p.name=" + p.name + "\t" + p.deepCloneableTarget.getCloneName() +
                "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p.name + "\t" + p2.deepCloneableTarget.getCloneName() +
                "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());

        // 方式2：完成深拷贝
        DeepProtoType p3 = (DeepProtoType) p.deepClone();
        System.out.println("p.name=" + p.name + "\t" + p.deepCloneableTarget.getCloneName() +
                "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p3.name=" + p3.name + "\t" + p3.deepCloneableTarget.getCloneName() +
                "p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode());

    }
}
