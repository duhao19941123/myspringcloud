package com.dh.controller;

import com.dh.dto.rqs.Student;
import com.dh.service.TypeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignClientController feignClientController;

    @GetMapping("test")
    @HystrixCommand(fallbackMethod = "fallBackTest")
    public String test(String string){

        return "master=====" + string ;
    }

    public String fallBackTest(String string){
        return "fallBackTest=====" + string ;
    }

    @GetMapping("ribbonTest")
    public String ribbonTest(String string){
        String url = "http://userserver/test/test?string=" + string;
        return restTemplate.getForObject(url ,String.class);
    }

    @GetMapping("feignTest")
    public String feignTest(String string){
        return feignClientController.test(string + "feignClientTest");
    }

    @GetMapping("feignTestPost")
    public String feignTestPost(@RequestParam("string") String string){
        return feignClientController.testPost(string + "feignClientTestPost");
    }

    @PostMapping("feignTestPostBody")
    public String feignTestPostBody(@RequestBody Student student){
        return feignClientController.testPostBody(student);
    }

    @Autowired
    private TypeService typeService;


    @GetMapping("testMysql")
    public Object testMysql(){
        return  typeService.getTypeByCode("signUpTimes") ;
    }
}
