package com.dh.dao;


import com.dh.entity.Type;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface Type2Dao {

    /**
     * 通过code,获取数据字典详情
     * @param code typecode
     * @return
     */
    List<Type> getTypeByCode(String code);

    void add(Type type);
}