package com.wedding.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wedding.business.AdminService;
import com.wedding.entity.Admin;




public class AdminLoginServlet extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result="login.jsp";
		String adminName=req.getParameter("adminName");
		String adminPwd=req.getParameter("adminPwd");
	
		if(adminName!=null && adminPwd!=null) {
			Admin admin=new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPwd(adminPwd);
			AdminService adminService=new AdminService();
			boolean bool=adminService.checkAdmin(admin);
			if(bool) {
				result="LoadAllProductServlet";
				req.getSession().setAttribute("admin", admin);
			}else {
				result="error.jsp";
			}
		}
		resp.sendRedirect(result);
		
		
	}
	

}
