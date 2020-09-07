package com.dh.service.impl;

import com.dh.dao.LcnUserMapper;
import com.dh.entity.LcnEntity;
import com.dh.service.LcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LcnServiceImpl implements LcnService {

    @Autowired
    LcnUserMapper lcnUserMapper;

    @Override
    public void add(LcnEntity lcnEntity) {
        lcnUserMapper.add(lcnEntity);
    }

}
