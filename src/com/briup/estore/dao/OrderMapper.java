package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Order;

public interface OrderMapper{
	public void saveOrder(Order order);
	public List<Order> findOrderById(Long id);
	public void deleteOrder(long id);
}
