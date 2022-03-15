package com.example.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口类
 * IP+端口+/hello 测试的程序是否可以正常运行，开始你的第一步
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
