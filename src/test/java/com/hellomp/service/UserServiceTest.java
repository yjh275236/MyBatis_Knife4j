package com.hellomp.service;

import com.hellomp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {


    @Autowired
    private UserService userService;

    //saveOrUpdate当有则更改，无则添加
    @Test
    public void testSaveOrUpdate() {
        User user1 = userService.getById(2);
        user1.setName("xiaohu");

        User user2 = new User();
        user2.setName("lisi");
        user2.setAge(27);
        user2.setEmail("lisi@email.com");
        userService.saveOrUpdate(user1);
        userService.saveOrUpdate(user2);
    }

    //一条sql批量增加数据
    @Test
    public void testSaveBatch() {
        User user1 = new User();
        user1.setName("dongdong");
        user1.setAge(49);
        user1.setEmail("dongdong@email.com");

        User user2 = new User();
        user2.setName("nannan");
        user2.setAge(29);
        user2.setEmail("nannan@email.com");


        List<User> users = List.of(user1, user2);
        userService.saveBatch(users);
    }
}