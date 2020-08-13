package com.dh.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dh.entity.Type;
import com.dh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class TestController {


    @Autowired
    private TypeService typeService;


    @GetMapping("add")
    public void add(){
        Type type  = new Type();
        String uuid = UUID.randomUUID().toString(); //转化为String对象
        System.out.println(uuid);  //打印UUID
        uuid = uuid.replace("-", "");   //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        type.setId(uuid);
        type.setTypecode("user2");
        type.setTypegroupid("a95eaa875a11490f8ee0d7ff74315bd2");
        type.setTypegroupid("1");
        type.setTypename("1");
        typeService.add(type);
    }
}