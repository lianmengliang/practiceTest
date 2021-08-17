package com.example;

import com.example.domain.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoBasicsApiApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User sel = userService.Sel(2);
        System.out.println(sel);
    }

}
