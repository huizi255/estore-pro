package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.IOrderServiceImpl;

public class SaveOrder extends HttpServlet{
	private static final long serialVersionUID = 591724165860470547L;
	private IOrderService orderService = new IOrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String payway = req.getParameter("payway");
		req.setAttribute("payway", payway);
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		Customer customer = (Customer) session.getAttribute("customer");
//		System.out.println(customer);
		Collection<Line> lines = shoppingCar.getLines().values();
//		System.out.println(lines);
		Order order = new Order();
		order.setCost(shoppingCar.getCost());
		order.setOrderDate(new Date());
		order.setCustomer(customer);
//		System.out.println(order);
		try {
			orderService.confirmOrder(customer, order,lines);
			req.setAttribute("msg", "已支付");
			req.getRequestDispatcher("listOrderServlet").forward(req, resp);
		} catch (OrderException e) {
			session.setAttribute("msg", "未支付");
			e.printStackTrace();
		}
	}
	
	

}
