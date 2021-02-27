package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBeanMed;
import com.mvc.dao.RegisterDaoMed;
import com.mvc.dao.DeleteDaoMed;

public class RegisterControllerMed extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	String fc=request.getParameter("fc"); 
        String password=request.getParameter("password");
        String status=request.getParameter("status");
        
        RegisterBeanMed regBeanMed=new RegisterBeanMed();
        
        regBeanMed.setFC(fc);
        regBeanMed.setPassword(password);
        System.out.println("fc: " + fc);
        System.out.println("password: " + password);
        System.out.println("status: " + status);
        if(status.equals("add")) {
        	RegisterDaoMed regDaoMed=new RegisterDaoMed();
            String registerMed=regDaoMed.authorizeRegister(regBeanMed);		            
            response.sendRedirect("AdminInterface.jsp");
        } else if (status.equals("del")) {
        	DeleteDaoMed delDaoMed=new DeleteDaoMed();
        	String deleteMed=delDaoMed.authorizeDelete(regBeanMed);	
        	response.sendRedirect("AdminInterface.jsp");
        }
	}
}
