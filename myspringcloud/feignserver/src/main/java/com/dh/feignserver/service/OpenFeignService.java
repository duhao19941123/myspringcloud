package com.dh.feignserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ASUS
 */
@FeignClient("userServer")
public interface OpenFeignService {

    @PostMapping("test/test")
    String add();
}
