package com.example.test.designpatterns.inversion;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 18:31
 * @Desc:
 */
public class DependcyInversion {
    public static void main(String[] args) {
        Person person = new Person();

        person.receive(new Email());
    }
}

class Email {
    public String getInfo(){
        return "电子邮件信息：hello，Email";
    }
}

class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}