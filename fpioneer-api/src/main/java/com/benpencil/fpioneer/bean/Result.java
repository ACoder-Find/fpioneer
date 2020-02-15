package com.benpencil.fpioneer.bean;

import java.io.Serializable;

public class Result implements Serializable {

    //msg 返回0代表注册，返回1代表登录
    private String type;

    private boolean successed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }
}