package com.example.login.bean;

/**
 * 用户Data类
 * 映射数据库的User表
 */
public class User {
    // 用于数据库主键
    private long id;
    // 用户名，不能重复
    private String accountNumber;
    // 用户密码
    private String password;
    // 手机号，数据库设置的可以为null，客户端可以不传入
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String account_number) {
        this.accountNumber = account_number;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
