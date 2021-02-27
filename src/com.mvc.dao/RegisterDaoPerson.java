package com.mvc.dao;

import java.sql.Connection;
import com.DB;
import java.sql.PreparedStatement;

import com.mvc.bean.RegisterBeanPerson;

public class RegisterDaoPerson
{
    public String authorizeRegister(RegisterBeanPerson regBeanPers) //create authorizeRegister()function
    {
    	String fc=regBeanPers.getFC();
        String firstname=regBeanPers.getFirstname();
        String lastname=regBeanPers.getLastname();
        String age=regBeanPers.getAge();  //get all value through registerBean object and store in temporary variable
        String city=regBeanPers.getCity();
        String gender=regBeanPers.getGender();
        
        try
        {
            Connection con=DB.getConnection();//create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into persona(cf,nome,cognome,eta,luogo,sesso) values(?,?,?,?,?,?)"); //sql insert query
            pstmt.setString(1,fc);
            pstmt.setString(2,firstname);
            pstmt.setString(3,lastname);
            pstmt.setString(4,age); 
            pstmt.setString(5,city); 
            pstmt.setString(6,gender); 
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