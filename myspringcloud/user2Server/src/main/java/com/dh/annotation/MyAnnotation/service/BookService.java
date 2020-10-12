package com.dh.annotation.MyAnnotation.service;

import com.dh.annotation.MyAnnotation.entity.BookEntity;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @author DH
 */
public interface BookService {


    List<BookEntity> getBook();
}
