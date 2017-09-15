package com.wedding.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.business.DiscountService;
import com.wedding.business.ProductService;

/**
 * Servlet implementation class DeleteDiscountServlet
 */
@WebServlet("/DeleteDiscountServlet")
public class DeleteDiscountServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] deleteDiscounts=req.getParameterValues("deleteDiscounts");
		
		String result="";
		if(deleteDiscounts!=null && deleteDiscounts.length>0){
			DiscountService discountService=new DiscountService();
			boolean bool=discountService.delete(deleteDiscounts);
			System.out.println(bool);
			String page=req.getSession().getAttribute("page").toString();
			result=bool?"LoadAllProductServlet?page"+page:"error.jsp";
		}
		resp.sendRedirect(result);
	}

}
