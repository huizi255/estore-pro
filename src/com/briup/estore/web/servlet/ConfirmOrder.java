package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.ICustomerServiceImpl;

public class ConfirmOrder extends HttpServlet{
	private static final long serialVersionUID = 5472469769981074141L;
	private ICustomerService customerService = new ICustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		Customer customer = (Customer) session.getAttribute("customer");
//		System.out.println(customer);
		req.getRequestDispatcher("user/confirmOrder.jsp").forward(req, resp);
	}

	
}
