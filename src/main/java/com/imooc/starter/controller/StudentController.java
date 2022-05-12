package com.imooc.starter.controller;

import com.imooc.starter.entity.Config;
import com.imooc.starter.entity.Employee;
import com.imooc.starter.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 接口增删改查
 */
//@Controller
@RestController //相当于Controller+ResposeBody
@Slf4j
@RequestMapping("student") //第一层路由
public class StudentController {

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
    public String getStudent(@PathVariable("stuId") String stuId,
                             @RequestParam Integer id,
                             @RequestParam String name) {

        log.info("stuId:" + stuId);
        log.info("id:" + id);
        log.info("name:" + name);
        return "查询信息";
    }

    /**
     * @param map
     * @param token
     * @param clientId
     * @return
     */
    @PostMapping("create")
    public String createStudent(@RequestBody Map<String, Object> map,
                                @RequestHeader("token") String token, //
                                @CookieValue("clientId") String clientId,
                                HttpServletRequest request) {
        log.info("map:" + map.toString());
        log.info("token:" + token);
        log.info("clientId:" + clientId);

        final String headerToken = request.getHeader("token");
        log.info("headerToken:" + headerToken);

        return "新增信息";
    }

    @PutMapping("update")
    public String updateStudent() {
        return "更新信息";
    }

    @DeleteMapping("delete")
    public String deleteStudent() {
        return "删除信息";
    }

}
