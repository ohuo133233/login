package com.example.login.controller;

import com.example.login.bean.Result;
import com.example.login.bean.User;
import com.example.login.serivce.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 相当于@Controller+@RequestBody
@RestController
// 访问目录
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param user 参数封装
     * @return Result<User> 返回注册成功或者注册失败的UserBean
     */
    @PostMapping(value = "/register")
    public Result<User> register(@RequestBody User user) {
        logger.info("register user: " + user.toString());
        return userService.register(user);
    }

    /**
     * 登录
     *
     * @param user 参数封装
     * @return Result<User> 返回登录成功或者注册失败的UserBean
     */
    @PostMapping(value = "/login")
    public Result<User> login(@RequestBody User user) {
        logger.info("login user: " + user.toString());
        return userService.login(user);
    }

}
