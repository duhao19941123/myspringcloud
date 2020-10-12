package com.dh.annotation.MyAnnotation.service.impl;

import com.dh.annotation.MyAnnotation.dao.BookDao;
import com.dh.annotation.MyAnnotation.entity.BookEntity;
import com.dh.annotation.MyAnnotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DH
 */
@Component
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    @Async
    public List<BookEntity> getBook() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("延迟执行了");
        return bookDao.getBook();
    }
}
