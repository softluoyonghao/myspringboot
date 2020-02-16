package com.luoamin.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果有多个参数，使用ApiImplicitParams
 * 最后访问http://localhost:8080/swagger-ui.html即可
 * swagger主要用来做restful API接口测试,另外用来构建restful api接口文档
 * Created by 22931 on 2020/2/16.
 */
@RestController
@RequestMapping(value="/swagger")
public class SwaggerController {
    @ApiOperation(value="获取用户信息", notes="根据id来获取用户详细信息")
    @ApiImplicitParam(name="id", value="用户ID", required=true, dataType="String")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Map<String,String> getInfo(@PathVariable String id) {
        Map<String ,String> map = new HashMap<String, String>();
        map.put("name", "lison");
        map.put("age", "38");
        return map;
    }
}
