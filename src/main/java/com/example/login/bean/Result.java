package com.example.login.bean;

/**
 * 返回给客户端包装的Result
 * 格式统一方便客户端解析和分析错误
 */
public class Result<T> {

    // 返回信息
    private String msg;

    // 返回code -1等于失败 200成功
    private int code;

    // 具体返回的数据
    private T detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", detail=" + detail +
                '}';
    }
}
