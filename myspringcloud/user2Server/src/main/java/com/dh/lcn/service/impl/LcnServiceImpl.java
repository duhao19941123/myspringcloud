package com.dh.lcn.service.impl;

import com.dh.lcn.dao.LcnMapper;
import com.dh.lcn.entity.LcnEntity;
import com.dh.lcn.service.LcnService;
import org.springframework.beans.factory.annotation.Autowired;

public class LcnServiceImpl implements LcnService {

    @Autowired
    LcnMapper lcnMapper;

    @Override
    public void add(LcnEntity lcnEntity) {
        lcnMapper.add(lcnEntity);
    }

}
