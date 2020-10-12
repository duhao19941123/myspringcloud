package com.dh.feignserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.dh.feignserver.service")
@SpringBootApplication
public class FeignserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignserverApplication.class, args);
    }

}
