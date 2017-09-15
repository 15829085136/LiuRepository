package com.wedding.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wedding.business.DiscountService;
import com.wedding.entity.Discount;

/**
 * Servlet implementation class LoadAllDiscountServlet
 */
@WebServlet("/LoadAllDiscountServlet")
public class LoadAllDiscountServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiscountService discountService=new DiscountService();
		int page=0;
		int displayCount=Integer.parseInt(req.getServletContext().getInitParameter("displayCount"));
		int maxPage=discountService.calctorMaxPage(displayCount);
		
		if(req.getParameter("page")!=null){
			int p=Integer.parseInt(req.getParameter("page"));
			
			if(p<0){
				p=maxPage;
			}
			if(p>maxPage){
				p=0;
			}
			page=p;
		}
		
		
		List<Discount> discountList=discountService.loadByPage(page, displayCount);
		req.getSession().setAttribute("discountList", displayCount);
		req.getSession().setAttribute("maxPage", maxPage);
		req.getSession().setAttribute("page", page);
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr=mapper.writeValueAsString(discountList);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println(jsonStr);
		
		
	}

}
