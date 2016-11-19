package com.briup.estore.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.dao.LineDao;
import com.briup.estore.dao.OrderDao;
import com.briup.estore.service.IOrderService;

public class IOrderServiceImpl implements IOrderService{
	private OrderDao orderDao = new OrderDao();
	private LineDao lineDao = new LineDao();

	@Override
	public void confirmOrder(Customer customer, Order order, Collection<Line> lines) throws OrderException {
		orderDao.save(order);
		for(Line l:lines){
			l.setOrder(order);
			lineDao.DoinsertLine(l);
		}
	}

	@Override
	public void deleteOrder(Long id) throws OrderException {
		orderDao.DodeleteOrder(id);
	}

	@Override
	public List<Order> findById(Long id) throws OrderException {
		List<Order> list = orderDao.findOrder(id);
		return list;
	}

}
