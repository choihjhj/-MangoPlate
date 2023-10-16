package com.my.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.customer.dto.Customer;
import com.my.customer.service.CustomerService;
import com.my.exception.AddException;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;

	public SignupServlet() {
//		service = new CustomerService();
		service=CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer c = new Customer();
		c.setId(request.getParameter("id"));
		c.setPwd(request.getParameter("pwd"));
		c.setName(request.getParameter("name"));
		int status = 0;
		try {
			service.signup(c);
			status = 1;
		} catch (AddException e) {
			status = 0;
		}

		String path = "/jsp/signupresult.jsp";
		request.setAttribute("status", status);

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

}