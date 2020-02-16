package com.luoamin.controller;

import com.luoamin.model.Users;
import com.luoamin.service.Userservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 22931 on 2020/2/16.
 */
@RestController
public class UserController {
    // springboot默认使用的logback，使用日志的使用slf4j的门面模式
    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Resource
    private Userservice userservice;

    @RequestMapping("/home")
    String home() {
        logger.info("========这是一个日志");
        return "Hello World!";
    }

    @RequestMapping("/login")
    public String login(){
        Users user=userservice.findByUsernameAndPasswd("111111","liyang");
        if(ObjectUtils.isEmpty(user)){
            return "登录失败！";
        }else{
            return "登录成功";
        }
    }

    /**
     * 上传密码和用户名
     * @param passwd http://localhost:8080/registed?passwd=111111&username=liyang
     * @param username
     * @return
     */
    @RequestMapping("/registed")
    public String registed(String passwd,String username){
        Users users=new Users();
        users.setPasswd(passwd);
        users.setUsername(username);
        int num=userservice.insertSelective(users);
        if(num<1){
            return "注册失败";
        }
        return "注册成功";
    }

}
