package com.example.test.javaBasis;

/**
 * @Author ： Leo
 * @Date : 2021/3/11 17:54
 * @Desc:
 */
public class operatorDemo {

    /**
     * 测试 位移运算符
     * & :如果相对应位都是1，则结果为1，否则为0
     *
     * | :如果相对应位都是 0，则结果为 0，否则为 1
     *
     * ^ :如果相对应位值相同，则结果为0，否则为1
     *
     * ~ :按位取反运算符翻转操作数的每一位，即0变成1，1变成0。
     *
     * >>:按位左移运算符。左操作数按位左移右操作数指定的位数。
     *     --->左移1位，相当于 乘以2(在一定范围内)
     *
     * <<:按位右移运算符。左操作数按位右移右操作数指定的位数。
     *     --->右移1位，相当于 除以2（在一定范围内）
     *
     * >>>:按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。
     */
    public static void testDisplacement(){
        int a = 9;
        int b = 8;
        //左移
       /* System.out.println("a<<2的结果:"+(a<<2));
        System.out.println("a<<3的结果:"+(a<<3));
        System.out.println("a<<的结果:"+(a<<30));*/

        //右移
//        System.out.println("a>>2的结果是："+(a>>2));

        // 面试题：最高效的方式的计算2*8 ？ --->2<<3 或 8<<1

        //取反
//        System.out.println("~a的结果："+ (~a));


        // ^ 的练习

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a的值是："+a);
        System.out.println("b的值是："+b);

    }

    public static void testThreeYuan(){


        int a= 2;
        int b= 22;
        int c= 12;

        int max = a>b?(a>c?a:c):(b>c?b:c);

        System.out.println(max);

        String s = Integer.toBinaryString(60);
        System.out.println(s);
    }



    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        testThreeYuan();
    }
}
