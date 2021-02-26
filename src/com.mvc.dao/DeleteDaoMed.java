package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DB;
import com.mvc.bean.RegisterBeanMed;

public class DeleteDaoMed {
	public String authorizeDelete(RegisterBeanMed regBeanMed) {	//create authorizeRegister()function
    	String fc=regBeanMed.getFC();
        String password=regBeanMed.getPassword();
        try
        {
            Connection con=DB.getConnection();//create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("SELECT * FROM MEDICO WHERE CF=? AND PASSWORD=?"); 
            pstmt.setString(1, fc);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
            	String dbcf=rs.getString("CF");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                String dbpassword=rs.getString("PASSWORD"); 
                
                if(fc.equals(dbcf) && password.equals(dbpassword)) {  //apply if condition check for fetchable database username and password are match for user input side type in textbox
                	 pstmt=con.prepareStatement("DELETE FROM MEDICO WHERE CF = ?"); //sql insert query
                     pstmt.setString(1,fc);
                     pstmt.executeUpdate(); //execute query
                      
                     pstmt.close(); //close statement
                     
                     con.close(); //close connection
                    
                     return "SUCCESS DELETE"; //if valid return string "SUCCESS DELETE" 
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL DELETE"; //if invalid return string "FAIL DELETE"
    }
}
