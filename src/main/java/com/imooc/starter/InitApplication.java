package com.imooc.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 1.表名当前为SpringBoot项目，这是一个启动类，也是程序的入口类；
 * 2.启动类需要放在根路径下，默认会扫描根包路径下的controller和Service以及mapper等一些相关组件，
 * 扫描完成之后会放在spring/springboot容器中
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.starter.mapper")
public class InitApplication {
    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class, args);
    }
}
