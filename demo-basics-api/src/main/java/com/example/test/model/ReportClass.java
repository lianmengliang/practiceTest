package com.example.test.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author ： Leo
 * @Date : 2021/8/9 12:22
 * @Desc:
 */
@Data
public class ReportClass {

    @JSONField(name = "下载数量")
    private int downloadNum;

    @JSONField(name = "渠道数量")
    private int channelNum;

    @JSONField(name = "广告数量")
    private int adNum;

    @JSONField(name = "日期")
    private String date;
}
