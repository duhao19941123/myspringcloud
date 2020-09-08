package com.dh.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("lcnClient")
public interface FeignClientController {

    @GetMapping("test/add")
    void add();

    @GetMapping("test/test")
    String test(@RequestParam("string")String string);
}
