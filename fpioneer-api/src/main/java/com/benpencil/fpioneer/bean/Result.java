package com.benpencil.fpioneer.bean;

import java.io.Serializable;

public class Result implements Serializable {

    //msg 返回0代表注册，返回1代表登录
    private String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}