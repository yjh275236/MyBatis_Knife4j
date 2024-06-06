package com.hellomp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hellomp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yjh
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-05 15:48:45
* @Entity com.hellomp.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectUserPage(IPage<User> page);
}




