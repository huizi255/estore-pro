package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.IBookServiceImpl;

public class ShopcartServlet extends HttpServlet{
	private static final long serialVersionUID = -5896464978314356147L;
	private IBookService iBookService = new IBookServiceImpl();
	private ShoppingCar shoppingCar;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id =Long.parseLong(req.getParameter("id"));
		Line line = new Line(id, 1);
//		System.out.println(id);
		HttpSession session = req.getSession();
		if(session.getAttribute("shoppingCar")==null){
			shoppingCar = new ShoppingCar();
		}else{
			shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		}
		try {
			Book book = iBookService.findById(id);
			line.setBook(book);
			shoppingCar.add(line);
//			System.out.println(shoppingCar.getLines().size());
			session.setAttribute("shoppingCar", shoppingCar);
			session.setAttribute("book", book);
			req.setAttribute("msg","添加成功");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (BookException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
