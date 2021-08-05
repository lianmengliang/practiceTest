package com.example.test;

/**
 * @Author ： leo
 * @Date :2020/3/19 10:51
 *
 * 1.判断数字在哪个等级
 * 2.再取余 相加
 */
public class testNumber {



    public static void main(String[] args) {
       /* long a = 10100;

        String relust ;
         relust = a/10000+"万"+ a%10000;
        System.out.println(relust);*/

        /**
         * 1：千
         * 2：万
         * 3：亿
         */

        int status ;
        Long num = 1001202003000L;

        if (num>=100000000) {
            status = 3;
        }else if (num>=10000){
            status =2 ;

        }else if(num>=1000){
            status =1 ;
        }else {
            status =0 ;
        }
        String relust1 = getRelust(num, status);

        System.out.println(relust1);
    }

    static String getRelust(Long num , int status){
        String relust ;
        if (status==3){

            relust = num/100000000 +"亿" + num%100000000/10000+"万" +num%100000000%10000/1000+"千"+num%100000000%10000%1000;

            return relust ;
        }else if (status==2){
            relust = num/10000+"万"+num%10000/1000+"千"+num%10000%1000;
            return relust ;
        }else if (status==1){
            relust = num/1000+"千"+num%1000;
            return relust ;
        }else {

            relust = num +"";

           return relust ;
        }

    }


}
