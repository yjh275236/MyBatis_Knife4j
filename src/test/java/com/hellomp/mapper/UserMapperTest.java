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
    //  根据id查询的功能
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    //因为设置ID自增所以不需要手动设置ID
    //插入信息
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("yjh");
        user.setAge(18);
        user.setEmail("130@qq.com");
        userMapper.insert(user);
    }

    //根据id修改信息
    @Test
    public void testUpdataById(){
        User user = userMapper.selectById(1);
        user.setName("xiaohong");
        userMapper.updateById(user);
    }

    //根据ID删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1);

    }



}