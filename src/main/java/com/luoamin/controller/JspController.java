package com.luoamin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springboot不推荐使用jsp，但是推荐使用模板引擎
 * Created by 22931 on 2020/2/16.
 */
@Controller
@RequestMapping("/pages/")
public class JspController {

    @RequestMapping("index")
    public String jspPage(){
        return "index";
    }
}
