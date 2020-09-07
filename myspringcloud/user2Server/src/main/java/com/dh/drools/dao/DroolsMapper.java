package com.dh.drools.dao;


import com.dh.drools.entity.DroolsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DroolsMapper {

    @Select("select id ,content from  drool")
    List<DroolsEntity> getList();
}
