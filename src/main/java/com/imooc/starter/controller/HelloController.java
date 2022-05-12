package com.imooc.starter.controller;

import com.imooc.starter.entity.Config;
import com.imooc.starter.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 演示示例
 */
//@Controller
@RestController //相当于Controller+ResposeBody
public class HelloController {

    //1.基本使用
    @RequestMapping("hello")
//    @ResponseBody
    public String hello() {
        return "Hello world!";
    }

    //2.控制反转，变量初始化在容器中
    @Autowired
    private Student student;

    @GetMapping("getStudent")
    public Student getStudent() {
        return student;
    }

    //3.读取配置信息
    @Autowired
    private Config config;

    @GetMapping("getConfig")
    public Config getConfig() {
        return config;
    }

    //4.自定义配置
    @Value("${self.custom.config.sdkKey}")
    private String sdkKey;

    @Value("${self.custom.config.host}")
    private String host;

    @Value("${self.custom.config.port}")
    private String port;

    @GetMapping("getCustomConfig")
    public String getCustomConfig() {
        return "sdkKey:" + sdkKey + ";\nhost:" + host + ";\nport:" + port;
    }
}
