package com.example.enums;

/**
 * @Author ： leo
 * @Date :2020/3/2 18:53
 */
public enum  testEnum {
    NETWORK_ERROR("-1", "网络错误，待会重试!"),
    XQ_BACKSTAGE_RESOURCE("-2", "您暂无权限,无法访问!"),

    SYSTEM_ERROR("-100","系统出错")
    ;
    //返回的错误标识
    private String code;
    //返回的错误消息
    private String msg;
    //返回的错误数据
    private String error;


    testEnum(String code, String msg, String error) {
        this.code = code;
        this.msg = msg;
        this.error = error;
    }

    testEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }}

