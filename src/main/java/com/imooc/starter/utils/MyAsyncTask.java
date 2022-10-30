package com.imooc.starter.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 异步任务
 */
@Component
@EnableAsync
@Slf4j
public class MyAsyncTask {
    @Async
    public void publishMsg() {

        try {
            Thread.sleep(5000);
            log.warn("异步任务开始：" + LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
