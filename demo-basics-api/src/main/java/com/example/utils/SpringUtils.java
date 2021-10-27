package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xiaobin on 2019-6-11.
 */
@Component
@Slf4j
public class SpringUtils implements ApplicationContextAware {

    // 声明一个静态变量保存
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 从spring容器里获取bean
     *
     * @param beanId
     */
    public static <T> T getBean(String beanId) {
        T bean = null;
        try {
            if (context != null && StringUtils.isNotEmpty(StringUtils.trim(beanId))) {
                bean = (T) context.getBean(beanId);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return bean;
    }

}
