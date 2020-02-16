package com.luoamin.util;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ControllerAdvice注解拦截所有requestmapping请求出现的RuntimeException异常
 * 全局异常处理
 * Created by 22931 on 2020/2/16.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object defaultHandler(HttpServletRequest re,Exception e) throws Exception{
        e.printStackTrace();
        return "这是一个异常";
    }


    /**
     * 第一使用jdk1.8lamd表达式，对于404等配置在web.xml的异常进行处理
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
//        return (factory->{
//            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.do");
//            factory.addErrorPages( error404Page);
//        });

        WebServerFactoryCustomizer<ConfigurableWebServerFactory>  result = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.do");
                factory.addErrorPages( error404Page);
            }
        };

        //jdk 1.8 lambda
        return  result;
    }

}
