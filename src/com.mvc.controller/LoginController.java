package com.mvc.controller;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("btn_login")!=null) { //check button click event not null from login.jsp page button
            String fc=request.getParameter("fc"); //get textbox name "txt_username"
            String password=request.getParameter("password"); //get textbox name "txt_password"
            String status=request.getParameter("status"); 
            
            LoginBean loginBean=new LoginBean(); //this class contain seeting up all received values from index.jsp page to setter and getter method for application require effectively 
            
            loginBean.setFC(fc); //set fc through loginBean object
            loginBean.setPassword(password); //set password through loginBean object
            loginBean.setStatus(status);
            
            LoginDao loginDao=new LoginDao(); //this class contain main logic to perform function calling and database operation
            
            String authorize=loginDao.authorizeLogin(loginBean); //send loginBean object values into authorizeLogin() function in LoginDao class
            
            if(authorize.equals("SUCCESS LOGIN")) { //check calling authorizeLogin() function receive string "SUCCESS LOGIN" message after continue process
                HttpSession session=request.getSession(); //session is created
                session.setAttribute("login",loginBean.getFC()); //session name is "fiscal code" and  store it in "getFC()" get through loginBean object
                switch(status) {
	                case "User": {
	                    RequestDispatcher rd=request.getRequestDispatcher("UserInterface.jsp"); //redirect to welcome.jsp page
	                    rd.forward(request, response); 
	                    break;
	                }
	                
	                case "Admin": {
	                    RequestDispatcher rd=request.getRequestDispatcher("AdminInterface.jsp"); //redirect to welcome.jsp page
	                    rd.forward(request, response);
	                    break;
	                }
	                case "Med": {
	                    RequestDispatcher rd=request.getRequestDispatcher("MedicoInterface.jsp"); //redirect to welcome.jsp page
	                    rd.forward(request, response);
	                    break;
	                }
                }
            }
            else {
                request.setAttribute("WrongLoginMsg",authorize); //wrong login error message is "WrongLoginMsg"
                RequestDispatcher rd=request.getRequestDispatcher("Home.jsp"); //show error same index.jsp page
                rd.include(request, response);
            }
        }
    }
}