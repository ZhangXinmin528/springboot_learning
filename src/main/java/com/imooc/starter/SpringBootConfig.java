package com.imooc.starter;

import com.imooc.starter.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 *
 * @Bean
 * @Controller
 * @Service
 * @Repository
 * @Component 这些组件注解也都能使用，根据场景以及类的业务去使用和定义即可
 */
//为了说明当前为配置类，可以被容器扫描到
@Configuration
public class SpringBootConfig {

    @Bean
    public Student student() {
        return new Student("jack", 18);
    }
}
