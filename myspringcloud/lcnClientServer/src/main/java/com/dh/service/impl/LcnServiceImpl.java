package com.dh.service.impl;

import com.dh.dao.LcnMapper;
import com.dh.entity.LcnEntity;
import com.dh.service.LcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LcnServiceImpl implements LcnService {

    @Autowired
    LcnMapper lcnMapper;

    @Override
    public void add(LcnEntity lcnEntity) {
        lcnMapper.add(lcnEntity);
    }

}
