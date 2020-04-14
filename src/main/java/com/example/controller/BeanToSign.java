package com.example.controller;

import com.example.domain.CpaTaskReviewLogRequest;
import com.example.response.ReviewResultResponse;
import com.example.utils.SortedKeySignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ： leo
 * @Date :2020/4/2 17:27
 */
@Api(value = "实体类生成签名")
@Slf4j
@RestController
public class BeanToSign {

    @ApiOperation(value = "新增或修改cpa任务审核记录")
    @PostMapping(value = "/editCpaTaskReviewLog")
    public ReviewResultResponse editCpaTaskReviewLog(@RequestBody CpaTaskReviewLogRequest reviewLogRequest ,@RequestParam(value = "secret") String secret){

        String sign = SortedKeySignUtil.sign(secret, reviewLogRequest);

        return ReviewResultResponse.builderSuccess(sign);
    }


}
