package com.imooc.starter.mapper;

import com.imooc.starter.my.mapper.MyMapper;
import com.imooc.starter.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {
}