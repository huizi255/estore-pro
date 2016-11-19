package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.SessionsTask;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.IOrderServiceImpl;

public class ListOrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IOrderService orderService = new IOrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Customer cust = (Customer) session.getAttribute("customer");
		Long id = cust.getId();
//		System.out.println(id);
		try {
			List<Order> order = orderService.findById(id);
//			System.out.println(order);
			cust.setOrders(order);
			session.setAttribute("order",order);
			session.removeAttribute("shoppingCar");
			req.getRequestDispatcher("user/order.jsp").forward(req, resp);
		} catch (OrderException e) {
			e.printStackTrace();
		}
	}
	
	

}
