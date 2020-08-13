package com.dh.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class TestController {


    @GetMapping("test")
    public String test(String string){

        return "master=====" + string ;
    }

}
