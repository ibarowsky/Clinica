package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBeanPerson;
import com.mvc.bean.RegisterBeanUser;
import com.mvc.dao.RegisterDaoPerson;
import com.mvc.dao.RegisterDaoUser;

public class RegisterControllerPerson extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        if(request.getParameter("btn_register")!=null) { //check button click event not null from register.jsp page button
        	String fc=request.getParameter("fc"); 
            String firstname=request.getParameter("firstname");
            String lastname=request.getParameter("lastname");
            String age=request.getParameter("age");  //get all textbox name from register.jsp page
            String city=request.getParameter("city"); 
            String gender=request.getParameter("gender");
            String password=request.getParameter("password");
            
            RegisterBeanPerson regBeanPers=new RegisterBeanPerson(); //this class contain setting up all received values from register.jsp page to setter and getter method for application require effectively
            
            regBeanPers.setFC(fc);
            regBeanPers.setFirstname(firstname);
            regBeanPers.setLastname(lastname);
            regBeanPers.setAge(age);  
            regBeanPers.setCity(city);
            regBeanPers.setGender(gender);	//set the all value through registerBean object
            
            RegisterDaoPerson regDaoPers=new RegisterDaoPerson(); //this class contain main logic to perform function calling and database operation
           
            String registerPerson=regDaoPers.authorizeRegister(regBeanPers); //send registerBean object values into authorizeRegister() function in RegisterDao class
            
            /* --------------------------------------------------------------------*/
            
            RegisterBeanUser regBeanUser=new RegisterBeanUser();
            
            regBeanUser.setFC(fc);
            regBeanUser.setPassword(password);
            
            RegisterDaoUser regDaoUser=new RegisterDaoUser();
            
            String registerUser=regDaoUser.authorizeRegister(regBeanUser);
            
            if(registerPerson.equals("SUCCESS REGISTER") && registerUser.equals("SUCCESS REGISTER")) { //check calling authorizeRegister() function receive "SUCCESS REGISTER" string message after redirect to index.jsp page
                //request.setAttribute("RegiseterSuccessMsg",registerValidate); //apply register successfully message "RegiseterSuccessMsg"
                RequestDispatcher rd=request.getRequestDispatcher("Home.jsp"); //redirect to index.jsp page
                rd.forward(request, response);
            }
            else {
                //request.setAttribute("RegisterErrorMsg",registerValidate); // apply register error message "RegiseterErrorMsg"
                RequestDispatcher rd=request.getRequestDispatcher("RegistrationInterface.jsp"); //show error same page register.jsp page
                rd.include(request, response);
            }
        }
    }
}