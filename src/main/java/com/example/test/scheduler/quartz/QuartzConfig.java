package com.example.test.scheduler.quartz;

import com.example.test.scheduler.ScheduledDemo;
import org.quartz.spi.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @Author ： Leo
 * @Date : 2021/6/7 15:03
 * @Desc: quartz框架使用配置 流程
 * 分为3个流程：
 * 1.创建job对象
 * 2.创建Trigger对象
 * 3.创建Scheduler对象
 */
@Configuration
public class QuartzConfig {

    /**
     * 1.创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ScheduledDemo.class);
        return factoryBean;
    }

    /**
     * 2.创建Trigger对象 ： 2种方式创建Trigger对象
     */
   /* @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        //  关联JobDetail对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        // 改参数表示一个执行的毫秒数
        factory.setRepeatInterval(200000);
        // 重复次数
        factory.setRepeatInterval(2);
        return factory;
    }*/
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean factoryBean) {
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(factoryBean.getObject());
        factory.setCronExpression("0/2 * * * * ?");
        return factory;
    }

    /**
     * 3. 创建Scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean factoryBean, MyAdaptableJobFactory jobFactory) {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();

        // 关联Trigger
        factory.setTriggers(factoryBean.getObject());

        /**
         * 该方法需要将实例化的任务对象手动添加到springIOC容器中，
         *  并且完成对象的注入
         */
        factory.setJobFactory(jobFactory);
        return factory;
    }
}
