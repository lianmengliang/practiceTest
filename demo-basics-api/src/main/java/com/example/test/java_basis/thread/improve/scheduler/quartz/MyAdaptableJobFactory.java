package com.example.test.java_basis.thread.improve.scheduler.quartz;


import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ： Leo
 * @Date : 2021/6/7 15:43
 * @Desc:
 */
@Component
public class MyAdaptableJobFactory extends AdaptableJobFactory {


    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    /**
     * 该方法需要将实例化的任务对象手动添加到springIOC容器中，
     *  并且完成对象的注入
     *
     * @param bundle
     * @return
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        // 将obj对象添加到Spring IOC容器中，并完成注入
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}
