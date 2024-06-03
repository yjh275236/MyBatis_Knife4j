package com.hellomp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hellomp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
