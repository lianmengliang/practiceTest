package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;

import java.util.*;

/**
 * @Author ： leo
 * @Date :2020/4/1 16:32
 */
@Slf4j
public class SortedKeySignUtil {


    private static final String SIGN_FIELD = "sign";

    /**
     * 获取签名
     *
     * @param secret
     * @param bean
     * @return
     */
    public static String sign(String secret, Object bean) {
        Map<String, String> map = beanToMap(bean);
        String sign = getSign(secret, map);
        log.info("成功生成签名{}" + sign);
        return sign;
    }

    /**
     * 验签
     *
     * @param appKey
     * @param bean
     * @return
     */
    public static boolean checkSign(String appKey, Object bean) {
        // 根据实体类 转化为Map集合
        Map<String, String> params = beanToMap(bean);

        Map<String, String> map = new HashMap<>();
        for (String key : params.keySet()) {
            if (!key.equalsIgnoreCase(SIGN_FIELD)) {
                map.put(key, params.get(key));
            }
        }

        String sign = getSign(appKey, map);
        if (!sign.isEmpty()) {
            if (sign.equalsIgnoreCase(params.get(SIGN_FIELD))) {
                log.info("验签成功");
                return true;
            }
        }
        return false;

    }

    /**
     * 生成签名
     *
     * @param appKey
     * @param map
     * @return
     */
    public static String getSign(String appKey, Map<String, String> map) {

        String result = "";
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(map.entrySet());
            //请求参数中的各个键值对 按照key的字符串顺序升序
            infoIds.sort(Comparator.comparing(Map.Entry<String, String>::getKey));

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    String val = item.getValue();
                    if (!(val == "" || val == null)) {
                        sb.append(val);
                    }
                }
            }

            //拼接后 MD5加密
            result = Md5Encrypt.MD5(sb.toString() + appKey);
        } catch (Exception e) {
            log.error("获取签名错误", e);
            return null;
        }
        return result;
    }

    /**
     * 实体类转化Map集合 -- 不包含sign字段
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, String> beanToMap(T bean) {
        Map<String, String> map = new HashMap<>();

        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (!key.toString().contains(SIGN_FIELD)) {
                    map.put(key + "", beanMap.get(key).toString());
                }
            }
        }
        return map;
    }

}
