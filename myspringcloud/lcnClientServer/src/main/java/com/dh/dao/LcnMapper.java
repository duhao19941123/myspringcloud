package com.dh.dao;


import com.dh.entity.LcnEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LcnMapper {

    void add(LcnEntity lcnEntity);

}
