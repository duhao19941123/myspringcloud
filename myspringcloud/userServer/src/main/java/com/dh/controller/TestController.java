package com.dh.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dh.entity.LcnEntity;
import com.dh.service.LcnService;
import com.dh.util.RedisUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class TestController {


    @Autowired
    private FeignClientController feignClientController;

    @Resource
    private RedisUtils redisUtils;


    @Autowired
    private LcnService lcnService;

    @Autowired
    private RestTemplate restTemplate;
    /**
     * redis功能测试
     */
    @PostMapping("redisTest")
    public void testRedis(){
        redisUtils.set("name" , 55555);
        System.out.println(redisUtils.get("name"));
    }

    @PostMapping("hystrixTest")
    public void hystrixTest(String string){
        String url = "http://lcnClient/test/testServer?string=" + string;
        String back = restTemplate.getForObject(url ,String.class);
        System.out.println(back);
//        System.out.println(feignClientController.test(string));
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

    /**
     * lcn分布式事务测试
     * @return
     */
    @PostMapping("test")
    @LcnTransaction
    @Transactional
    public String test(){
        feignClientController.add();
        this.add();
        return "123";
    }
    @GetMapping("add")
    public void add(){
        LcnEntity lcnEntity = new LcnEntity();
        lcnEntity.setContent("主content");
        lcnService.add(lcnEntity);
    }
}
