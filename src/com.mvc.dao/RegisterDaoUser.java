package com.mvc.dao;

import java.sql.Connection;
import com.DB;
import java.sql.PreparedStatement;
import com.mvc.bean.RegisterBeanUser;

public class RegisterDaoUser {
    public String authorizeRegister(RegisterBeanUser rbu) //create authorizeRegister()function
    {
    	String fc=rbu.getFC();
    	String password=rbu.getPassword();
        
        try
        {
            Connection con=DB.getConnection();//create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into utente(cf,password) values(?,?)"); //sql insert query
            pstmt.setString(1,fc);
            pstmt.setString(2,password);

            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }
}