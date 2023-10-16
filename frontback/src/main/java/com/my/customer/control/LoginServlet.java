package com.my.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.customer.dto.Customer;
import com.my.customer.service.CustomerService;
import com.my.exception.FindException;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private CustomerService service;
   public LoginServlet() {
//      service = new CustomerService();
	   service=CustomerService.getInstance();
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      
      
      HttpSession session=request.getSession();
      session.removeAttribute("loginedID");     
      int status = 0;
      
      try {
         Customer c = service.login(id, pwd);
         status = 1;
         session.setAttribute("loginedId", id);
      } catch(FindException e) {
         status = 0;
      }
      
      String path = "/jsp/loginresult.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(path);
      request.setAttribute("status", status);
      rd.forward(request, response);
      
   }

}