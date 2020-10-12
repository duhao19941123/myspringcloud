package com.dh.annotation.MyAnnotation.dao;

import com.dh.annotation.MyAnnotation.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DH
 */
@Mapper
public interface BookDao {

    List<BookEntity> getBook();
}
