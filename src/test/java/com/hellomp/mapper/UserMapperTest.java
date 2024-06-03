package com.hellomp.mapper;

import com.hellomp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    //forEach()  Java 8 中的方法引用语法来遍历集合并打印出每个元素
    //打印user的所有内容
    @Test
    public void testList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
//        users.forEach(name -> System.out.println(name));
    }



}