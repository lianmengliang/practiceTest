package com.example.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author ReveeWu
 * @create 2019-10-28 19:54
 */
@ApiModel("标准通用结果")
@Data
@Builder
public class CommonResult<T> {
    private static final long serialVersionUID = -4641709205708801779L;
    @ApiModelProperty("接口业务状态。0：成功 其他失败")
    private int code;
    @ApiModelProperty("结果描述")
    private String msg;
    @ApiModelProperty("业务状态成功时返回的数据")
    private T data;

    public static <T> CommonResult<T> builderSuccess(T data) {
        return CommonResult.<T>builder()
                .code(0)
                .msg("操作成功")
                .data(data)
                .build();
    }
    public static  CommonResult builderSuccess() {
        return CommonResult.builder()
                .code(0)
                .msg("操作成功")
                .build();
    }
    public static  CommonResult builderSuccess(String msg) {
        return CommonResult.builder()
                .code(0)
                .msg(msg)
                .build();
    }
    public static  CommonResult builderSuccess(int code, String msg) {
        return CommonResult.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T> CommonResult<T> builderSuccess(String msg,T data) {
        return CommonResult.<T>builder()
                .code(0)
                .msg(msg)
                .data(data)
                .build();
    }

    public static CommonResult builderError(String msg) {
        return CommonResult.builder()
                .code(1)
                .msg(msg)
                .build();
    }

    public static CommonResult builderError(int code, String msg) {
        return CommonResult.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T> CommonResult<T> builderError(int code, String msg, T data) {
        return CommonResult.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }
}
