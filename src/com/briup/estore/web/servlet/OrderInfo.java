package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.service.ILineService;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.ILineServiceImpl;
import com.briup.estore.service.impl.IOrderServiceImpl;

public class OrderInfo extends HttpServlet{
	private static final long serialVersionUID = -6228663642482941749L;
	private ILineService lineService = new ILineServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("orderid"));
		List<Line> line = lineService.findById(id);
		req.setAttribute("line", line);
		req.getRequestDispatcher("user/orderinfo.jsp").forward(req, resp);
//		System.out.println(line);
//		System.out.println(list);
//		System.out.println(id);
//		lineService.findById(id)
	}
	
	

}
