package com.dh.controller;

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
    public String test(@RequestParam("string")String string){

        int n = 1/0;
        return "master=====" + string ;
    }

    public String fallBackTest(String string){
        return "fallBackTest=====" + string ;
    }

    @GetMapping("ribbonTest")
    public String ribbonTest(String string){
        String url = "http://userServer/test/testServer?string=" + string;
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

    @GetMapping("testServer")
    @HystrixCommand(fallbackMethod = "testErr")
    public String testServer(@RequestParam("string") String string){
        if(string.equals("1")){
            int n = 1/0;
        }
        return "成功返回" + string;
    }


    public String testErr(@RequestParam("string") String string){
        return "失败返回" + string;
    }
}
