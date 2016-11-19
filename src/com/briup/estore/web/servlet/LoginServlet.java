package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.ICustomerServiceImpl;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 8195629771204200292L;
	private ICustomerService iCustomerService = new ICustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userid");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		try {
			Customer customer = iCustomerService.login(name, password);
			session.setAttribute("customer", customer);
			req.setAttribute("msg", "登录成功");
			req.getRequestDispatcher("ListBookServlet").forward(req, resp);
		} catch (CustomerException e) {
			req.setAttribute("msg", "登录失败");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	
	

}
