package com.wedding.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wedding.business.ProductService;
import com.wedding.business.ProductTypeService;
import com.wedding.entity.Product;

public class SaveProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Product product=new Product();
		product.setProductId(Integer.parseInt(req.getParameter("productId")));
		product.setProductName(req.getParameter("productName"));
		product.setProductInPrice(Double.parseDouble(req.getParameter("productInPrice")));
		product.setProductOutPrice(Double.parseDouble(req.getParameter("productOutPrice")));
		String productTypeName=req.getParameter("productTypeName");
		ProductTypeService productTypeService=new ProductTypeService();
		System.out.println(productTypeName);
		int productTypeId=productTypeService.SelectProductTypeNameById(productTypeName);
		product.setProductTypeId(productTypeId);
		
		
		
		ProductService productService=new ProductService();
		boolean bool=productService.save(product);
		int displayCount=Integer.parseInt(getServletContext().getInitParameter("displayCount"));
		int maxPage=productService.calctorMaxPage(displayCount);
		System.out.println(bool);
		resp.sendRedirect(bool?"LoadAllProductServlet?page="+maxPage:"error.jsp");
		
	}

}
