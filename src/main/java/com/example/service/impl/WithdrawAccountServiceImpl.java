package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.response.CommonResult;
import com.example.service.WithdrawAccountService;
import com.example.utils.OkHttpUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： leo
 * @Date :2020/6/17 17:05
 */

@Slf4j
@Service
public class WithdrawAccountServiceImpl implements WithdrawAccountService {


    @Override
    public CommonResult queryAccountBalance() {
        Map<String, String> map = new HashMap<>();


        String xlBalance = this.queryXlBalance();
        map.put("薪龙", this.dealString(xlBalance));




        return CommonResult.builderSuccess(map);
    }

    /**
     * 查询薪龙账户余额
     *
     * @return
     *
     * jsonResult1 =
     * {
     *     "code":"0000",
     *     "message":"SUCCESS",
     *     "data":{
     *         "uid":"110809395436228609",
     *         "accountList":[
     *             {
     *                 "account_id":"20010010011200032873982100001",
     *                 "account_type":"BASIC",
     *                 "available_balance":"10608.87",
     *                 "balance":"10608.87",
     *                 "current_balance_direction":"CREDIT",
     *                 "sub_account_no":"00090050"
     *             }
     *         ],
     *         "transit_amount":"50.00"
     *     }
     * }
     *
     * jsonResult2 =
     * {
     *     "uid":"110809395436228609",
     *     "accountList":[
     *         {
     *             "account_id":"20010010011200032873982100001",
     *             "account_type":"BASIC",
     *             "available_balance":"10608.87",
     *             "balance":"10608.87",
     *             "current_balance_direction":"CREDIT",
     *             "sub_account_no":"00090050"
     *         }
     *     ],
     *     "transit_amount":"50.00"
     * }
     *
     */
    private String queryXlBalance() {

        //请求链接
        String url = "https://mogu.wangzhuantianxia.com/khl/get/balance";
        log.info(MessageFormat.format("薪龙账户余额查询：{0}", url));

        String result = OkHttpUtil.requestOfGet(url, null, "");
        log.info(MessageFormat.format("薪龙账户余额查询结果：{0}", result));
        JSONObject balance = JSON.parseObject(result);



        int status = balance.getIntValue("status");
        if (status == 0) {

            /*String data = (String) balance.get("data");

            JSONObject jsonResult1 = JSON.parseObject(data);

            JSONObject jsonResult2 = jsonResult1.getJSONObject("data");

            JSONArray jsonArray = jsonResult2.getJSONArray("accountList");*/


            //JSONArray jsonArray = JSON.parseObject(balance.get("data").toString()).getJSONObject("data").getJSONArray("accountList");

            JSONArray jsonArray = balance.getJSONObject("data").getJSONObject("data").getJSONArray("accountList");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                String available_balance = object.getString("available_balance");

                return available_balance ;
            }



        }

        return null;
    }

    private void dealJsonString(){
        String js = "";

//        JSONObject object = new JSONObject(js);

    }


    private String dealString(String balance) {
        if (StringUtils.isEmpty(balance)) {
            return "0";
        } else {
            return balance;
        }
    }
}
