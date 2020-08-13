package com.dh.controller;


import com.dh.dto.rqs.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("userserver")
public interface FeignClientController {


    @GetMapping("test/test")
    String test(@RequestParam("string") String string);

    @PostMapping("test/testPost")
    String testPost(@RequestParam("string") String string);

    @PostMapping("test/testPostBody")
    String testPostBody(@RequestBody Student student);
}
