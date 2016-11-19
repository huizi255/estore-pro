package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;

public class UpdateProduct extends HttpServlet{
	private static final long serialVersionUID = 5347142504103219668L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("number"));
		long id = Long.parseLong(req.getParameter("productid"));
//		System.out.println(num);
//		System.out.println(id);
		HttpSession session = req.getSession();
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		Map<Long, Line> lines = shoppingCar.getLines();
		Line line = lines.get(id);
		line.setNum(num);
//		System.out.println(line);
		req.getRequestDispatcher("shopcart.jsp").forward(req, resp);
	}
	
	

}
