package com.briup.estore.dao;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;

public class CustomerDao {
	public void save(Customer customer){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.saveCustomer(customer);
		sqlSession.commit();
	}

	public Customer findCustomerByName(String name){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer cust = mapper.findByName(name);
		return cust;
	}
	
	public void doUpdateCustomer(Customer customer){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.updateCustomer(customer);
		sqlSession.commit();
	}

}
