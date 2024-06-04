package com.hellomp.wrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hellomp.entity.User;
import com.hellomp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryWrapper() {

        //查询name=Tom的所有用户
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("name", "Tom");

        //查询邮箱域名为baomidou.com的所有用户
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.like("email", "baomidou.com");

        //查询所有用户信息并按照age字段降序排序
        QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.orderByDesc("age");

        //查询age介于[20,30]的所有用户
        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.between("age", 20, 30);

        //查询age小于20或大于30的用户
        QueryWrapper<User> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lt("age", 20).or().gt("age", 30);

        //邮箱域名为baomidou.com且年龄小于30或大于40且的用户
        QueryWrapper<User> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.like("email", "baomidou.com").and(wrapper -> wrapper.lt("age", 30).or().gt("age", 40));

        List<User> list = userService.list(queryWrapper6);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {

        //将name=Tom的用户的email改为Tom@baobidou.com
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "Tom");
        updateWrapper.set("email", "Tom@baobidou.com");

        userService.update(updateWrapper);
    }
}