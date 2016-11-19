package com.briup.estore.dao;

import java.util.ArrayList;
import java.util.List;
import com.briup.estore.bean.Book;

public interface BookMapper {
	public List<Book> queryAll();
	public Book queryById(Long id);
}
