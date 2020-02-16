package com.luoamin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 22931 on 2020/2/16.
 */
@RestController
public class BaseErrorController {

    @RequestMapping("404.do")
    public String error_404(){
        return "页面出现404";
    }
}
