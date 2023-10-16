package com.my.product.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.customer.service.CustomerService;
import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.product.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public ProductServlet() {
//		service = new ProductService();
		service= ProductService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNo = request.getParameter("prodNo");
		Product p=new Product();
		try {
		p=service.findByProdNo(prodNo);
		
		request.setAttribute("prod_no",p.getProdNo());
		request.setAttribute("prod_name",p.getProdName());
		request.setAttribute("prod_price",p.getProdPrice());
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		
		
		String path = "/jsp/productresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
