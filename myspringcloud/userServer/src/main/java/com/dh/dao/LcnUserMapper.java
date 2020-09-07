package com.dh.dao;


import com.dh.entity.LcnEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LcnUserMapper {

    void add(LcnEntity lcnEntity);

}
