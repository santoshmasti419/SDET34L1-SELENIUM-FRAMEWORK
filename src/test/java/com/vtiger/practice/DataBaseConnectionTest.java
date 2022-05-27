package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class DataBaseConnectionTest {

	public static void main(String[] args) throws SQLException {
		//step1: Create object for implemention class
		Driver driver=new Driver();
		
		//step2:Resister the driver with JDBC
		DriverManager.registerDriver(driver);
		
		//step3:Establish the database connection
		Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECTS", "root", "root");
		
		//step4:Create the Statement
	    Statement Statement = Connection.createStatement();
	    //String query="insert into project values('TY_PROJ_007','SANTOSH','10/05/2022','SDET34','On GOING','3')";
	    
	    //step5:Execute the query
	     ResultSet Result = Statement.executeQuery("SELECT* FROM PROJECT");

	    
	    //step6:Validate(based on testcase)
	   while(Result.next())
	   {
		   System.out.println(Result.getInt(1));
	   }
	    
	    //step7:close the connection
	    Connection.close();

	}
}


