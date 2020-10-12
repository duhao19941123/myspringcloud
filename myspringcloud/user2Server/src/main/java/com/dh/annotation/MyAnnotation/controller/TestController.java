package com.dh.annotation.MyAnnotation.controller;

import com.dh.annotation.MyAnnotation.config.LogAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DH
 * 测试接口类
 */
@RestController
@RequestMapping("logTest")
public class TestController {


    @RequestMapping("test")
    @LogAnnotation(age = 10, userName = "张三")
    public void test(){
        System.out.println("执行代码了===============");
    }

}
