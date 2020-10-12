package com.dh.feignserver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dh.feignserver.service.BlockHandlerService;
import com.dh.feignserver.service.OpenFeignService;
import com.dh.feignserver.service.impl.BlockHandlerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private OpenFeignService openFeignService;

    @SentinelResource(value = "demoTest",fallback = "fallBack")
    @RequestMapping("test")
    public void test(String id){
        System.out.println("成功返回=======");
    }

    public void fallBack(String id , BlockException ex){
        System.out.println("降级成功返回=======");
    }

    @Autowired
    private BlockHandlerService blockHandlerService;

    @RequestMapping("test2")
    public void test(Integer id){
        System.out.println(blockHandlerService.test(String.valueOf(id)));
    }

    @SentinelResource(value = "helloResource" ,fallback = "helloFallback")
    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "id") Long id)  {
        if(id == 1L){
            throw  new RuntimeException("1231");
        }
        return "SUCCESS";
    }
    public String helloFallback(Long id , Throwable e) {
        System.out.println(1111);
        return id+"helloFallback";
    }
    public String getOrderDowngradeRtTypeFallback(Long id,BlockException ex) {
        return "服务降级啦，当前服务器请求次数过多，请稍后重试!";
    }
}
