package com.example.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.login.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 数据库
 * 使用mybatis-plus 简化SQL的编写
 * 只需保证BaseMapper<>的泛型的bean是和数据库的映射就行
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
