package com.example.test.scheduler;

import com.example.service.impl.AddUserService;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author ： Leo
 * @Date : 2021/6/7 11:57
 * @Desc:
 */
//@Component
public class ScheduledDemo implements Job {

    @Autowired
    private AddUserService addUserService;
    /*@Scheduled(cron="0/2 * * * * ?")
    public static void scheduledTask(){
        System.out.println("任务调度时间是：" + new Date());
    }*/

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务调度时间是：" + new Date());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addUserService.addUsers();
    }
}
