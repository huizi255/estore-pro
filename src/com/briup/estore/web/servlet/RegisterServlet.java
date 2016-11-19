package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.ICustomerServiceImpl;

public class RegisterServlet extends HttpServlet{
	private ICustomerService iCustomerService = new ICustomerServiceImpl();
	private Customer customer;
	private static final long serialVersionUID = -2238041225206812574L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		customer = new Customer();
		String name = req.getParameter("userid");
		customer.setName(name);
		String pwd = req.getParameter("password");
		customer.setPassword(pwd);
		String country = req.getParameter("country");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String street1 = req.getParameter("street1");
		System.out.println(street1);
		String street2 = req.getParameter("street2");
		String zip = req.getParameter("zip");
		customer.setZip(zip);
		String homephone = req.getParameter("homephone");
		String officephone = req.getParameter("officephone");
		String cellphone = req.getParameter("cellphone");
		String email = req.getParameter("email");
		customer.setEmail(email);
		if(!street1.equals("")){
			String address=country+province+city+street1;
			customer.setAddress(address);
		}
		else{
			String address=country+province+city+street2;
			customer.setAddress(address);
			
		}
		if(!cellphone.equals("")){
			String telephone = cellphone;
			customer.setTelephone(telephone);
		}else{
			if(!homephone.equals("")){
				String telephone = homephone;
				customer.setTelephone(telephone);
			}else{
				String telephone = officephone;
				customer.setTelephone(telephone);
			}
		}
//		System.out.println(customer);
		try {
			iCustomerService.register(customer);
			req.setAttribute("msg", "注册成功");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} catch (CustomerException e) {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			e.printStackTrace();
		}

	}
	
	

}
