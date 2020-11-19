package com.example.login.dao;

import com.example.login.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     *
     * @param account_number
     * @return
     */
    @Select(value = "select u.account_number,u.password from user u where u.account_number=#{account_number}")
    @Results({@Result(property = "account_number", column = "account_number"),
            @Result(property = "password", column = "password")})
    User findUserByName(@Param("account_number") String account_number);

    /**
     * 注册  插入一条user记录
     *
     * @param user
     * @return
     */

    @Insert("insert into user values(#{id},#{account_number},#{password},#{phone})")
    // 加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void register(User user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Select("select u.id from user u where u.account_number = #{account_number} and password = #{password}")
    Long login(User user);
}
