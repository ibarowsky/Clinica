package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	  public static Connection con=null;
	  public static Connection getConnection(){
	    String DB_URL="jdbc:mysql://localhost:3306/Becuba";
	    String name="admin";
	    String password="";
	    try{
	      Class.forName("com.mysql.jdbc.Driver");
	      con=DriverManager.getConnection(DB_URL, name, password);
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	    return con;
	  }
}
