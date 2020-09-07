package com.dh.lcn.controller;

import com.dh.lcn.entity.LcnEntity;
import com.dh.lcn.service.LcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lcn")
public class LcnController {


    @Autowired
    private LcnService lcnService;

    @PostMapping("test")
    public String add(){
        LcnEntity lcnEntity = new LcnEntity();
        lcnEntity.setContent("this is content");
        lcnService.add(lcnEntity);
        return "success";
    }



}
