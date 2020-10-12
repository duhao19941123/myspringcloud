package com.dh.feignserver.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dh.feignserver.service.BlockHandlerService;
import org.springframework.stereotype.Service;

@Service
public class BlockHandlerServiceImpl implements BlockHandlerService {

    @Override
    @SentinelResource(value = "test", fallback = "testBlockHandler")
    public String test(String id) {
        if("1".equals(id)){
            System.out.println("===========================");
            int n = 1/0;
        }
        return  "成功了";
    }

    public String testBlockHandler(String id ) {
        return  "失败之后返回数据";
    }

}
