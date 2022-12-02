package com.imooc.starter.controller;

import com.imooc.starter.entity.Student;
import com.imooc.starter.pojo.User;
import com.imooc.starter.service.UserService;
import com.imooc.starter.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 数据库的增删改查
 */
//@Controller
@RestController //相当于Controller+ResposeBody
@Slf4j
@RequestMapping("user") //第一层路由
public class UserController {

//    @Autowired
//    private UserService userService;

    /**
     * 1.添加路径参数
     * 2. @RequestParam:用于获取url中的请求参数，如果参数变量名保持一致，该注解可以忽略
     *
     * @param stuId
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/{stuId}/get")
    public String getUser(@PathVariable("stuId") String stuId,
                          @RequestParam Integer id,
                          @RequestParam String name) {

        log.info("stuId:" + stuId);
        log.info("id:" + id);
        log.info("name:" + name);
        return "查询信息";
    }

    /**
     * @return
     */
    @PostMapping("create")
    public JsonResult createUser() {
        final String sid = UUID.randomUUID().toString();
        final User user = new User();
        user.setId(sid);
        user.setName("张三");
        user.setSex(1);
//        userService.saveUser(user);
        return JsonResult.success(null);
    }

    @PutMapping("update")
    public String updateStudent() {
        return "更新信息";
    }

    @DeleteMapping("delete")
    public String deleteStudent() {
        return "删除信息";
    }


    //6.返回响应对象
    @GetMapping("getStudentInfo")
    public JsonResult getStudentInfo() {
        final Student student = new Student("jack", 22);
        return JsonResult.success(student);
    }
}
