package com.example.firstproject.domain;

public class Hello {
    private int code;
    private String msg;

    public Hello(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
