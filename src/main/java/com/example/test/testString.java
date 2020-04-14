package com.example.test;

/**
 * @Author ： leo
 * @Date :2020/2/27 18:38
 */
public class testString {
    public static void main(String[] args) {
        getString();
    }

    public static void getString(){

        String[] split = "asd,fg,hjk".split(",");
        String s = "asd,fg,hjk".split("\\,")[0];

        System.out.println(split);
        System.out.println(s);
    }

    public String getStr(){
        String str = null;

        if (str.equals("1122")){
            return "321312";
        }else {
            return  "31231";
        }
    }
}
