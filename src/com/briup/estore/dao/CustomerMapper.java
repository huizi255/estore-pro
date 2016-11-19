package com.briup.estore.dao;

import com.briup.estore.bean.Customer;

public interface CustomerMapper {
	public Customer findByName(String name);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
}
