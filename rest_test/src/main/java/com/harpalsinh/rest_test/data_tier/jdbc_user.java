package com.harpalsinh.rest_test.data_tier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.harpalsinh.rest_test.pojo.user;

public class jdbc_user {
	
	public List<user> getList()
	{
		Connection conn = null;
		   Statement stmt = null;
		   List<user> list=new LinkedList<user>();
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
		      sql = "SELECT * FROM user_details";
		      ResultSet rs = stmt.executeQuery(sql);
		      //Extract data from result set
		      while(rs.next()){
		    	  user uTemp=new user();
		    	  uTemp.setUser_id(rs.getInt("user_id"));
		    	  uTemp.setUser_firstname(rs.getString("user_firstname"));
		    	  uTemp.setUser_lastname(rs.getString("user_lastname"));
		    	  uTemp.setUser_age(rs.getInt("user_age"));
		    	  uTemp.setUser_email(rs.getString("user_email"));
		    	  uTemp.setUser_country(rs.getString("user_country"));
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
	public user getById(int userid)
	{
		Connection conn = null;
		   Statement stmt = null;
		   user uu=null;
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
		      sql = "SELECT * FROM user_details WHERE user_id="+userid;
		      ResultSet rs = stmt.executeQuery(sql);
		      //Extract data from result set
		      if(rs.next()){
		    	  user uTemp=new user();
		    	  uTemp.setUser_id(rs.getInt("user_id"));
		    	  uTemp.setUser_firstname(rs.getString("user_firstname"));
		    	  uTemp.setUser_lastname(rs.getString("user_lastname"));
		    	  uTemp.setUser_age(rs.getInt("user_age"));
		    	  uTemp.setUser_email(rs.getString("user_email"));
		    	  uTemp.setUser_country(rs.getString("user_country"));
		    	  uu=uTemp;
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
		   return uu;
	}

}
