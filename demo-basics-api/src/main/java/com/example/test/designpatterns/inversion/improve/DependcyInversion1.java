package com.example.test.designpatterns.inversion.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 18:31
 * @Desc:
 */
public class DependcyInversion1 {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

/**
 * 接口
 */
interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息：hello，Email";
    }
}


class WeChat implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息：hello，WeChat";
    }
}


class Person1 {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

/*
class testPerson extends Person1{

    public  void main(String[] args) {

        receive(new IReceiver() {
            @Override
            public String getInfo() {
                return null;
            }
        });
    }
}*/
