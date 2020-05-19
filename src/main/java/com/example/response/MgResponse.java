package com.example.response;

import com.example.enums.MgAdError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 *
 * @description: 接口统一返回
 * @author: Mr.Zou
 * @create: 2019-07-03 18:20
 **/
@Data
public class MgResponse<T> {
    /**
     * //请求成功返回码
     */
    private static final String SUCCESSCODE = "100";

    /**
     *     //返回码
     */
    private String code;


    /**
     * //返回消息
     */
    private String msg;


    /**
     * //返回正确数据
     */
    private T data;

    /**
     *     //返回错误数据
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T error;


    /**
     * //当前页
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer page;

    /**
     *     //显示数量
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Long total;

    public MgResponse() {
        this.code = SUCCESSCODE;
        this.msg = "请求成功";
    }

    public MgResponse(MgAdError error) {
        this(error.getError(), error.getMsg(), null);
    }

    //成功返回
    public MgResponse(T data) {
        this();
        this.data = data;
    }

    //成功返回
    public MgResponse(T data, Integer page, Long total) {
        this();
        this.data = data;
        this.page = page;
        this.total = total;
    }

    //错误输出
    public MgResponse(String code, String msg, T error) {
        this.code = code;
        this.msg = msg;
        this.error = error;
    }


}
