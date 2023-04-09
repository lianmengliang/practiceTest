package com.example.test.java_basis.method;

/**
 * lianmengliang
 * <p>
 * 4/30/22 6:39 PM
 * author: leo
 */
public class MethodDemo {
    public static void main(String[] args) {


        Methods methods = new Methods();
        int sum = methods.sum(2, 3, 3);
        System.out.println(sum);


        System.out.println("--------------------------");
        methods.say();

    }
}

/**
 * 反编译
 */
class Dog{
    Dog(){

    }
    public Dog(String name){

    }
}

class Methods {

    public int sum(int... nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 可变参数只能放在方法参数后面，并且可以和其他参数一起混用，一个方法中只能用一个可变参数
     *
     * @param str
     * @param nums
     */
    public void f1(String str, double... nums) {

    }


    String name = "jack";

    public void say() {
        //细节 属性和局部变量可以重名，访问时 遵循就近原则
        String name = "leo";
        System.out.println("name: " + name);
    }
}