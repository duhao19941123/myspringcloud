package com.dh.lcn.service;

import com.dh.lcn.entity.LcnEntity;
import org.springframework.stereotype.Service;

@Service
public interface LcnService {

    void add(LcnEntity lcnEntity);
}
