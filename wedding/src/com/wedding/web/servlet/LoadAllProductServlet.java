package com.wedding.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wedding.business.ProductService;
import com.wedding.entity.Product;




public class LoadAllProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String callBack=req.getParameter("callBack");
		ProductService productService=new ProductService();
		int page=0;
		int displayCount=Integer.parseInt(this.getServletContext().getInitParameter("displayCount"));
		int maxPage=productService.calctorMaxPage(displayCount);
		
		if(req.getParameter("page")!=null) {
			int p=Integer.parseInt(req.getParameter("page"));
			
			if(p<0) {
				p=maxPage;
			}
			
			if(p>maxPage) {
				p=0;
			}
			
			page=p;
		}
		
		List<Product> productList=productService.loadByPage(page, displayCount);
		req.getSession().setAttribute("productList", productList);
		req.getSession().setAttribute("maxPage", maxPage);
		req.getSession().setAttribute("page", page);
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr=mapper.writeValueAsString(productList);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println(jsonStr);
	
	}

}
