package com.example.test;

import com.example.domain.User;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Author ： Leo
 * @Date : 2020/9/11 14:31
 * @Desc:
 */
public class test0001 {

    public static void main(String[] args) {

       /* if (StringUtils.containsIgnoreCase("test", "pro") || StringUtils.containsIgnoreCase("test", "protest")) {

            System.out.println("true");

        }else{
            System.out.println("false");
        }

        User user = new User();

        user.setId(1)
                .setUserName("leo")
                .setId(1)
                .setPassWord("123123")
                .setRealName("12312");
*/

        Map<String, Integer> map = new HashMap<>();

        map.put("key",1);
        map.put("web",1);
        map.put("edv",1);
        for (String str : map.keySet()){
            System.out.println(str+"-"+map.get(str));
        }

        map.forEach((k,v) -> System.out.println(k+"-"+v));



    }
}
/*

0--0--
0--1--
0--2--
1--0--
1--1--
1--2--*/
