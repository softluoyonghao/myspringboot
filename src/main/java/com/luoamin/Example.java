package com.luoamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by 22931 on 2020/2/15.
 * SpringBootApplication注解会扫描当前类所属包下的包以及子类
 * 此注解以后就在项目中经常使用
 * EnableTransactionManagement注解尽量加上，不加也可以在service使用事务
 */
//@RestController
//@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.luoamin.dao")
@EnableTransactionManagement
public class Example {
    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }

}
