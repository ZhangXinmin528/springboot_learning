package com.imooc.starter.controller;

import com.imooc.starter.entity.Config;
import com.imooc.starter.entity.Employee;
import com.imooc.starter.entity.Student;
import com.imooc.starter.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 演示示例
 */
//@Controller
@RestController //相当于Controller+ResposeBody
@Slf4j
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

    //5.lombok插件提升开发效率
    @GetMapping("getEmployee")
    public Employee getEmployee() {
        final Employee employee = new Employee();
        employee.setId(1001);
        employee.setDepartment("人力");
        log.info(employee.toString());
        log.error(employee.toString());
        return employee;
    }

    //6.返回响应对象
    @GetMapping("getEmployeeResult")
    public JsonResult getEmployeeResult() {
        final Employee employee = new Employee();
        employee.setId(1001);
        employee.setDepartment("人力");
        log.info(employee.toString());
        log.error(employee.toString());
        return JsonResult.success(employee);
    }

    //7.文件上-有问题
    @PostMapping("upload")
    public JsonResult upload(MultipartFile file) {
        try {
            file.transferTo(new File("/temp/" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonResult.success(null);
    }
}
