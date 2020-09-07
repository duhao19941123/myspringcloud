package com.dh.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dh.entity.LcnEntity;
import com.dh.service.LcnService;
import com.dh.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * redis功能测试
     */
    @PostMapping("redisTest")
    public void testRedis(){
        redisUtils.set("name" , 55555);
        System.out.println(redisUtils.get("name"));
    }


    /**
     * lcn分布式事务测试
     * @return
     */
    @GetMapping("test")
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
