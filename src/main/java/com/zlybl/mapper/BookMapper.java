package com.zlybl.mapper;

import com.zlybl.pojo.Book;

import java.util.List;

public interface BookMapper {
    //全查书
    List<Book> selectAll();
}
