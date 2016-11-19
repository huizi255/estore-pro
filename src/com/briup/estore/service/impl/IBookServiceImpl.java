package com.briup.estore.service.impl;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.dao.BookDao;
import com.briup.estore.service.IBookService;

public class IBookServiceImpl implements IBookService{
	private BookDao bookDao = new BookDao();

	@Override
	public List<Book> listAllBooks() throws BookException {
		return bookDao.queryBookAll();
	}

	@Override
	public Book findById(Long id) throws BookException {
		return bookDao.queryBookById(id);
	}

}
