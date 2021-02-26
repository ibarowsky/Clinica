package com.mvc.dao;

import com.mvc.bean.LoginBean;
import com.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public String authorizeLogin(LoginBean loginBean) { //create authorizeLogin()function
        String fc=loginBean.getFC(); //get username value through loginBean object and store in temporary variable "username"
        String password=loginBean.getPassword(); //get password value through loginBean object and store in temporary variable "password"
        String status=loginBean.getStatus();
        
        String dbcf="";  //create two variable for use next process
        String dbpassword="";
        
        try {
	        Connection con=DB.getConnection(); //create connection
	        PreparedStatement pstmt=null; //create statement
	        
	        switch(status) {
		        case "User": {             
		                pstmt=con.prepareStatement("SELECT * FROM UTENTE WHERE CF=? AND PASSWORD=?"); //sql select query 
		                pstmt.setString(1,fc);
		                pstmt.setString(2,password);
		                ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
		                 
		                while(rs.next()) {    
		                	dbcf=rs.getString("CF");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
		                    dbpassword=rs.getString("PASSWORD"); 
		                    
		                    if(fc.equals(dbcf) && password.equals(dbpassword)) {  //apply if condition check for fetchable database username and password are match for user input side type in textbox
		                        return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
		                    }
		                }  
		        	break;
		        }
		        
		        case "Admin": {            
		                pstmt=con.prepareStatement("SELECT * FROM ADMIN WHERE CF=? AND PASSWORD=?"); //sql select query 
		                pstmt.setString(1,fc);
		                pstmt.setString(2,password);
		                ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
		                 
		                while(rs.next()) {    
		                	dbcf=rs.getString("CF");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
		                    dbpassword=rs.getString("PASSWORD"); 
		                    
		                    if(fc.equals(dbcf) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
		                    {
		                        return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
		                    }
		                }
		        	break;
		        }
		        
		        case "Med": {
		                pstmt=con.prepareStatement("SELECT * FROM MEDICO WHERE CF=? AND PASSWORD=?"); //sql select query 
		                pstmt.setString(1,fc);
		                pstmt.setString(2,password);
		                ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
		                 
		                while(rs.next()) {    
		                	dbcf=rs.getString("CF");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
		                    dbpassword=rs.getString("PASSWORD"); 
		                    
		                    if(fc.equals(dbcf) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
		                    {
		                        return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
		                    }
		                }
		                break;
		        }
	        }
	        
	        pstmt.close(); //close statement
	        
	        con.close(); //close connection
	        
        } catch(Exception e) {
        	e.printStackTrace();
        }
       
        return "WRONG USERNAME AND PASSWORD"; //if invalid condition return string "WRONG USERNAME AND PASSWORD"
    }
}