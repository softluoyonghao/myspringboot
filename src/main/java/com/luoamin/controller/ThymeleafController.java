package com.luoamin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模板引擎不用配置视图解析器，比jsp要简单，所以页面更推荐用模板引擎
 * 尽量不要用jsp
 * Created by 22931 on 2020/2/16.
 */
@Controller
@RequestMapping("/templatepages/")
public class ThymeleafController {
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap map) {
        // 设置属性
        map.addAttribute("name", "enjoy");
        // testThymeleaf：为模板文件的名称
        // 对应src/main/resources/templates/testThymeleaf.html
        return "testThymeleaf";
    }

}
