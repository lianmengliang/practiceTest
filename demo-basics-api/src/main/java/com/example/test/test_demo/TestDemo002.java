package com.example.test.test_demo;

/**
 * lianmengliang
 * <p>
 * 2021-10-22 20:51
 */
public class TestDemo002 {
    public static void main(String[] args) {


       /* int x = 4;
        System.out.println("sss:"+((x>4?99.9:9)));*/
       /* int num = 0;

        for (int i = 0; i < 100; i++) {
            num = ++num;
        }

        System.out.println(num);
        System.out.println(++num);*/
        String str = "k:1|k2:2|k3:3";
        System.out.println(str.contains("k"));
        System.out.println(str.indexOf("k21"));

        test2();
    }

    /**
     * 组装json字符串  "k:1|k2:2|k3:3"
     * <p>
     * {"k":1","k2":"2","k3":"3"}
     */
    public static void test1() {
        String str = "k:1|k2:2|k3:3";

        String str1 = str.replace("|", ",");


        char[] str2 = str1.toCharArray();
        StringBuilder bulider = new StringBuilder("{");
        for (int i = 0; i < str2.length; i++) {
            if (i == str2.length - 1) {
                bulider.append("}");
            } else if (str2[i] == ',' || str2[i] == ':') {
                bulider.append(str2[i]);
            } else {
                bulider.append("\"").append(str2[i]).append("\"");
            }
        }

        System.out.println(bulider.toString());

    }

    /**
     *
     */
    public static void test2() {
        String str = "k:1|k2:2|k3:3";


        String[] split = str.split("\\|");
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < split.length; i++) {


            String[] str1 = split[i].split(":");
            builder.append("\"")
                    .append(str1[0])
                    .append("\"")
                    .append(":")
                    .append("\"")
                    .append(str1[1])
                    .append("\"");
            if (i == split.length - 1) {
                builder.append("}");
            }else{
                builder.append(",");
            }
        }

        System.out.println(builder.toString());
    }

    /**
     *
     */
    public static void test3() {

    }

    /**
     *
     */
    public static void test4() {

    }

    /**
     *
     */
    public static void test5() {

    }

    /**
     *
     */
    public static void test6() {

    }
}
