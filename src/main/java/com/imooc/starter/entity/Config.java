package com.imooc.starter.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 读取配置信息:把本配置放入到SpringBoot容器中，使其被扫描到
 */
@ConfigurationProperties(prefix = "user")//读取带有该前缀的配置信息
@PropertySource(value = "classpath:Config.properties", encoding = "utf-8")//文件位置
@Component
public class Config {
    public String userName;//可能会和本地服务冲突
    public int age;
    public String sex;

    public Config() {
    }

    public Config(String name, int age, String sex) {
        this.userName = name;
        this.age = age;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
