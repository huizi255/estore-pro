package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.IBookServiceImpl;

public class ListBookServlet extends HttpServlet{
	private static final long serialVersionUID = 2905981218447218331L;
	private IBookService iBookService = new IBookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Book> listAllBooks = iBookService.listAllBooks();
			HttpSession session = req.getSession();
			session.setAttribute("listAllBooks", listAllBooks);
			resp.sendRedirect("index.jsp");
		} catch (BookException e) {
			e.printStackTrace();
		}
	}
	
	

}
