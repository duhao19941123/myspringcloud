package com.dh.lcn.dao;


import com.dh.lcn.entity.LcnEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LcnMapper {

    void add(LcnEntity lcnEntity);

}
