package com.briup.estore.service.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.service.ICustomerService;

public class ICustomerServiceImpl implements ICustomerService{
	private CustomerDao customerDao = new CustomerDao();

	@Override
	public void register(Customer customer) throws CustomerException {
		Customer cust= customerDao.findCustomerByName(customer.getName());
		if(cust!=null){
			throw new CustomerException("用户名已存在");
		}else{
			customerDao.save(customer);
		}
	}

	@Override
	public Customer login(String name, String password) throws CustomerException {
		Customer costomer = null;
		Customer cust = customerDao.findCustomerByName(name);
		if(cust!=null){
			if(cust.getPassword().equals(password)){
				costomer = cust;
			}
		}else{
			throw new CustomerException("用户名不存在");
		}
		return costomer;
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
			customerDao.doUpdateCustomer(customer);
	}
}
