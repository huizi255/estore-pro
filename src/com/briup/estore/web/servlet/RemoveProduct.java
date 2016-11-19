package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;

public class RemoveProduct extends HttpServlet{
	private static final long serialVersionUID = -511021929084738529L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("productid"));
//		System.out.println(id);
		HttpSession session = req.getSession();
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		shoppingCar.delete(id);
		req.getRequestDispatcher("shopcart.jsp").forward(req,resp);
	}
	
	

}
