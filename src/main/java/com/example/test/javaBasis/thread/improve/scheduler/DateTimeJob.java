package com.example.test.javaBasis.thread.improve.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author ： Leo
 * @Date : 2021/6/7 14:45
 * @Desc:  Quartz是一个开源的任务调度框架。基于定时、定期的策略来执行任务是它的核心功能
 *          下面是一个 集成quartz框架后一个 小demo
 */
public class DateTimeJob {
    public static void main(String[] args) throws SchedulerException {

        // 1.创建Job对象 -- > 你需要做什么事情
        JobDetail job = JobBuilder.newJob(ScheduledDemo.class).build();

        // 2.创建Trigger对象 -- > 在什么时候做？
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        // 3.创建Scheduler对象，在什么时候做什么事
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }
}
