package com.imooc.starter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 使用lombok插件提升开发效率
 */
@Data //生成get和set方法
@ToString //生成toString方法
@NoArgsConstructor  //生成默认构造函数
@AllArgsConstructor //生成全参数构造函数
public class Employee {
    public int id;
    public String department;
}
