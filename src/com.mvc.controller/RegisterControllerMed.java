package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBeanMed;
import com.mvc.dao.RegisterDaoMed;
import com.mvc.dao.DeleteDaoMed;

public class RegisterControllerMed {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		 if(request.getParameter("btn_register")!=null) { //check button click event not null from register.jsp page button
	        	String fc=request.getParameter("fc"); 
	            String password=request.getParameter("password");
	            String status=request.getParameter("status");
	            
	            RegisterBeanMed regBeanMed=new RegisterBeanMed();
	            
	            regBeanMed.setFC(fc);
	            regBeanMed.setPassword(password);
	            
	            if(status.equals("add")) {
	            	RegisterDaoMed regDaoMed=new RegisterDaoMed();
		            String registerMed=regDaoMed.authorizeRegister(regBeanMed);		            
		            response.sendRedirect("AdminInterface.jsp");
	            } else {
	            	DeleteDaoMed delDaoMed=new DeleteDaoMed();
	            	String deleteMed=delDaoMed.authorizeDelete(regBeanMed);	
	            	response.sendRedirect("AdminInterface.jsp");
	            }
	            
	            
		 }
	}
}
