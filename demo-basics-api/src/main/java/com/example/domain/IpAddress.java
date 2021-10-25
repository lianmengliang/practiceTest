package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author ： Leo
 * @Date : 2020/11/2 14:34
 * @Desc:
 */

@Data
@Accessors(chain = true)
public class IpAddress {

   /*  <locationInfo>
  <ret>ok</ret>
  <ip>112.17.25.148</ip>
  <data>
   <country>中国</country>
   <region>浙江</region>
   <city>金华</city>
   <district></district>
   <isp>移动</isp>
   <zip>321000</zip>
   <zone>0579</zone>
  </data>
 </locationInfo>*/
//@JSONField(name = "order_id")
//    private String orderId;

    @JSONField(name = "country")
    private String country;

    @JSONField(name = "region")
    private String region;

    @JSONField(name = "city")
    private String city;

    @JSONField(name = "isp")
    private String isp;

    @JSONField(name = "zip")   //邮政编码
    private Integer zip;


    @JSONField(name = "zone")  //地区编号
    private Integer zone;
}
