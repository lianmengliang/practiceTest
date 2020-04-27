package com.example.test;

/**
 * @Author ： leo
 * @Date :2020/2/27 18:38
 */
public class testString {
    public static void main(String[] args) {
        getStr2();
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
    public static void getStr1(){
        String config = "/try/try_cpl_plus.aspx?adid= 6106";

        String[] split = config.split("'?'");
        String[] split1 = config.split("[?]",2);
        for (String s : split1) {
            System.out.println(s);
        }

        System.out.println("qewq?".replaceAll("[?]","a"));
        System.out.println(config.split("[?]")[1]);
    }
    public static void getStr2(){

        String adid="4589";

        String arg = "/try/try_cpl_plus.aspx";

        String format = String.format("%s?adid=%s",arg, adid);

        System.out.println(format);
    }
}
