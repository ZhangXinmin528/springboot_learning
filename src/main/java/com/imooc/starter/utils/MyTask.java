package com.imooc.starter.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 定时任务
 */
//@Configuration //1.标记了配置类，使得SpringBoot容器可以扫描
//@EnableScheduling //2.开启定时任务
@Slf4j
public class MyTask {
    //3.添加一个定时任务，并且著名任务的运行表达式
    @Scheduled(cron = "0/2 * * * * ?")
    public void publishMsg() {
        log.warn("开始执行任务：" + LocalDateTime.now());
    }
}
