package com.dh.controller;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dh.dto.rqs.Student;
import com.dh.entity.Type;
import com.dh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class LCNController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignClientController feignClientController;

    @Autowired
    private TypeService typeService;

    @GetMapping("testLCN")
    public void testLCN(){
        typeService.getMaxFourElementTimes();
    }


    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional()
    @GetMapping("add")
    public void add(){
        Type type  = new Type();
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        type.setId(uuid);
        type.setTypecode("client");
        type.setTypegroupid("a95eaa875a11490f8ee0d7ff74315bd2");
//        type.setTypegroupid("1");
        type.setTypename("1");

        typeService.add(type);
    }




}
