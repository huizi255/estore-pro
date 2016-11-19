package com.briup.estore.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Order;

public class OrderDao {
	public void save(Order order){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.saveOrder(order);
		sqlSession.commit();
	}
	
	public void DodeleteOrder(long id){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.deleteOrder(id);
		sqlSession.commit();
	}
	
	public List<Order> findOrder(Long id){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> listOrder = mapper.findOrderById(id);
		return listOrder;
	} 

}
