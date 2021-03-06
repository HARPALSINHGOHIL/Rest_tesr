package com.harpalsinh.rest_test.data_tier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.harpalsinh.rest_test.pojo.user_contact_detail;

public class jdbc_user_contact {

	public List<user_contact_detail> getById(int userid)
	{
		Connection conn = null;
		   Statement stmt = null;
		   List<user_contact_detail> list=new LinkedList<user_contact_detail>();
		   try{
		      //Register JDBC driver
		      Class.forName(jdbc_init.JDBC_DRIVER);

		      //Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(jdbc_init.DB_URL,jdbc_init.USER,jdbc_init.PASS);

		      //Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM user_contact_details WHERE user_id="+userid;
		      ResultSet rs = stmt.executeQuery(sql);
		      //Extract data from result set
		      while(rs.next()){
		    	  user_contact_detail uTemp=new user_contact_detail();
		    	  uTemp.setContact_id(rs.getInt("contact_id"));
		    	  uTemp.setPhone_number(rs.getLong("phone_number"));
		    	  uTemp.setComments(rs.getString("comments"));
		    	  //Adding it to list
		    	  list.add(uTemp);
		      }
		      //Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("run successful");
		   return list;
	}
}
