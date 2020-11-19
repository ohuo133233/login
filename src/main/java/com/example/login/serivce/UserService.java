package com.example.login.serivce;

import com.example.login.bean.Result;
import com.example.login.bean.User;
import com.example.login.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    public Result register(User user) {
        Result result = new Result();
        result.setCode(-1);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getAccount_number());
            if (existUser != null) {
                //如果用户名已存在
                result.setCode(-1);
                result.setMsg("用户名已存在");
            } else {
                userMapper.register(user);
                result.setMsg("注册成功");
                result.setCode(200);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setCode(-1);
        result.setDetail(null);
        try {
            Long userId = userMapper.login(user);
            if (userId == null) {
                result.setCode(-1);
                result.setMsg("用户名或密码错误");
            } else {
                result.setCode(200);
                result.setMsg("登录成功");
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
