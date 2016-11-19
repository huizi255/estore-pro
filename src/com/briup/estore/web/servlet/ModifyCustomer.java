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

public class ModifyCustomer extends HttpServlet{
	private static final long serialVersionUID = -4179952316557782851L;
	private ICustomerService customerService = new ICustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userid");
		Customer cust;
		try {
			cust = new Customer();
			cust.setName(name);
			String pwd = req.getParameter("password");
			cust.setPassword(pwd);
			String street1 = req.getParameter("street1");
			String street2 = req.getParameter("street2");
			String zip = req.getParameter("zip");
			cust.setZip(zip);
			String homephone = req.getParameter("homephone");
			String officephone = req.getParameter("officephone");
			String cellphone = req.getParameter("cellphone");
			String email = req.getParameter("email");
			cust.setEmail(email);
			if(!street1.equals("")){
				cust.setAddress(street1);
			}
			else{
				cust.setAddress(street2);
			}
			if(!cellphone.equals("")){
				String telephone = cellphone;
				cust.setTelephone(telephone);
			}else{
				if(!homephone.equals("")){
					String telephone = homephone;
					cust.setTelephone(telephone);
				}else{
					String telephone = officephone;
					cust.setTelephone(telephone);
				}
			}
//			System.out.println(cust);
			
			customerService.updateCustomer(cust);
			HttpSession session = req.getSession();
			session.setAttribute("customer", cust);
			req.setAttribute("msg", "更新成功");
			req.getRequestDispatcher("user/userinfo.jsp").forward(req, resp);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	

}
