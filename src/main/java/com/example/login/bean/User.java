package com.example.login.bean;

/**
 * 用户Data类
 */
public class User {
    // 用于数据库主键
    private long id;
    // 用户名，不能重复
    private String account_number;
    // 用户密码
    private String password;
    // 手机号
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
