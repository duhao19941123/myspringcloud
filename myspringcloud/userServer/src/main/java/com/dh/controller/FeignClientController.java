package com.dh.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("lcnClient")
public interface FeignClientController {

    @GetMapping("test/add")
    void add();

}
