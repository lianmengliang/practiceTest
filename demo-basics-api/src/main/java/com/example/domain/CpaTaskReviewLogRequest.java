package com.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * @Author ： leo
 * @Date :2020/4/1 15:06
 */
@Data
public class CpaTaskReviewLogRequest {

    private Long logid;

    private Long appid;

    private String appsign;

    private Integer adid;

    private String adname;

    private String adimg;

    private Integer taskid;

    private String describe;

    private Integer dayno;

    private BigDecimal award;

    private Integer itemid;

    private Integer itemtype;

    private String answer;

    private Integer status;

    private String rejectCause;

    private String sign ;
}
