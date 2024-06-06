package com.hellomp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomp.entity.User;
import com.hellomp.service.UserService;
import com.hellomp.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yjh
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-06-05 15:48:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




