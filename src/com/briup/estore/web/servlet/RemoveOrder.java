package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.IOrderServiceImpl;

public class RemoveOrder extends HttpServlet{
	private static final long serialVersionUID = 6913982120457803741L;
	private IOrderService orderService = new IOrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("orderid"));
		try {
			orderService.deleteOrder(id);
			req.getRequestDispatcher("listOrderServlet").forward(req, resp);
		} catch (OrderException e) {
			e.printStackTrace();
		}
	}
	
	

}
