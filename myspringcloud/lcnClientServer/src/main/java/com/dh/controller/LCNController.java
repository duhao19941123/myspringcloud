package com.dh.controller;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dh.entity.LcnEntity;
import com.dh.service.LcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by miyakohiroshi on 2020/7/10.
 */
@RequestMapping("test")
@RestController
public class LCNController {


    @Autowired
    private LcnService lcnService;

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional()
    @GetMapping("add")
    public void add() {
        LcnEntity lcnEntity = new LcnEntity();
        lcnEntity.setContent("子content");
        lcnService.add(lcnEntity);
    }


}
