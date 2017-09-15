package com.wedding.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.business.ProductService;


public class DeleteProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] deleteProducts=req.getParameterValues("deleteProducts");
		
		String result="";
		if(deleteProducts!=null && deleteProducts.length>0){
			ProductService productService=new ProductService();
			boolean bool=productService.delete(deleteProducts);
			System.out.println(bool);
			String page=req.getSession().getAttribute("page").toString();
			result=bool?"LoadAllProductServlet?page"+page:"error.jsp";
		}
		resp.sendRedirect(result);
	}

}
