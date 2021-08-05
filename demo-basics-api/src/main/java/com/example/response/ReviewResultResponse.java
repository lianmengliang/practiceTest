package com.example.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @Author ： leo
 * @Date :2020/4/1 12:26
 */
@Data
@ApiModel(value = "审核结果返回信息")
@Builder
public class ReviewResultResponse {


    private  int  success ;

    private String msg ;

    public static  ReviewResultResponse builderSuccess(String msg) {
        return ReviewResultResponse.builder()
                .success(0)
                .msg(msg)
                .build();
    }
    public static  ReviewResultResponse builderError(String msg) {
        return ReviewResultResponse.builder()
                .success(0)
                .msg(msg)
                .build();
    }
}
