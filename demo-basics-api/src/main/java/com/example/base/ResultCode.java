package com.example.base;

/**
 * Created with IntelliJ IDEA.
 * PACKAGE_NAME:com.xw.ad.common.base
 * AUTHOR: hexOr
 * DATE :2019/3/5 20:23
 * DESCRIPTION:通用响应码
 */
public interface ResultCode {

    /**
     * 获取结果码
     *
     * @return
     */
    String getCode();

    /**
     * 获取结果描述
     *
     * @return
     */
    String getDesc();
}
