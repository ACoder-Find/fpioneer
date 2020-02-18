package com.benpencil.fpioneer.bean;

import java.io.Serializable;

public class Result implements Serializable {

    //注册成功、登录成功、密码输入错误或者账号已存在
    private String message ;

    private boolean succeed ;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}