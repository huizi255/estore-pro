package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;

public class BookDao {
	public List<Book> queryBookAll(){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = mapper.queryAll();
		return list;
	}
	
	public Book queryBookById(long id){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.queryById(id);
		return book;
	}

}
