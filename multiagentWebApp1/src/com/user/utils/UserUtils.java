package com.user.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c.beans.user;
import db.connection.mySQLConnUtils;
import db.utils.dbUtils;

public class UserUtils {
	
	
	  
	 
	  public static List<user> getUserData(Connection conn) throws SQLException {
//		  Connection conn = mySQLConnUtils.getMySQLConnection();
		  
		  List<user> userData = new ArrayList<user>();
			 
	      String sql = "Select * from multiagent.user";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
//	      pstm.setString(1);
	 
	      ResultSet rs = pstm.executeQuery();
	      
	      int id;
	      String username ;
	      String email;
	      String phone;
	      String password;
	      String adminOrUser;
//	      userAccount user = new userAccount();
	 
	      while (rs.next()) {
	    	  id = rs.getInt(1);
	    	  username = rs.getString(2);
	    	  email = rs.getString(3);
	    	  password = rs.getString(4);
	    	  phone = rs.getString(5);
	    	  adminOrUser = rs.getString(6);
	    	  
	    	  user user = new user();
	    	  user.setuserID(id);
	          user.setname(username);
	          user.setpassword(password);
	          user.setemail(email);
	          user.setphone(phone);
//	          user.setPassword(password);
	          user.setadminOrUser(adminOrUser);
	          userData.add(user);
//	          return userData;
	      }
	      return userData;
	  }
	  
	  public static int UpdateUser(Connection conn,int ID,String name,String email,String phone,String Password,String adminOrUser) throws SQLException {
			 
	      String sql = "UPDATE multiagent.user SET name=?, email=?,password=?,phone=?,adminOrUser=? WHERE userID=?; ";
	 
	      String hashedPassword = dbUtils.preparePassword(Password, email);
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, name);
	      pstm.setString(3, hashedPassword);
	      pstm.setString(2, email);
	      pstm.setString(4, phone);
	      pstm.setString(5, adminOrUser);
	      pstm.setInt(6, ID);
	      int rs = pstm.executeUpdate();
	 
//	      if (rs.next()) {
//	          String password = rs.getString("password1");
//	          user user = new user();
//	          user.setpassword(password);
//	          return 1;
//	      }
	      return rs;
	  }
	  
	  public static void delete(int id){
		  String sql = "DELETE FROM multiagent.user " + "WHERE userID = ?";
		  Connection conn = null;
		  PreparedStatement pstm = null;
//		  int rs;
		try {
			conn = mySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, id);
			 pstm.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	  }
	  
//	  public static String checkIfAdmin(Connection conn, String username, String password) throws SQLException{
//		  String sql = "select user_jobDescription from user_table where username = ? and user_password = ?";
//		  PreparedStatement pstm = conn.prepareStatement(sql);
//		  pstm.setString(1, username);
//	      pstm.setString(2, password);
//	      String jobRole = "Hello";
////	      userAccount user = new userAccount();
//	      ResultSet rs = pstm.executeQuery();
//	      while (rs.next()) {
//////	    	  userAccount user = new userAccount();
//	    	   jobRole = rs.getString(1);
//////	    	  user.setJobDescription(jobRole);
////	    	  return user;
//	      }
//	      return  jobRole;
//		  
//	  }

//	
//	public static userAccount checkIfAdmin(Connection conn, String username, String password) throws SQLException{
////		  String sql = "select * from user_table where username = ? and user_password = ?";
//		  String sql = "select * from user_table where username = ?";
//		  String email = null;
//		  String jobDescription = null;
//		  String hPassword = null;
//		  String dPassword = null;
//		  PreparedStatement pstm = conn.prepareStatement(sql);
//		  pstm.setString(1, username);
////		  pstm.setString(2, password);
////	    String jobRole = "Hello";
//	//    userAccount user = new userAccount();
//	    ResultSet rs = pstm.executeQuery();
//	    while (rs.next()) {
//	    	email = rs.getString(3);
//	    	dPassword = rs.getString(5);
//	    	jobDescription = rs.getString(6);
//	    	hPassword = dbUtils.preparePassword(password, email);
////	  	  	userAccount user = new userAccount();
////	  	   jobRole = rs.getString(1);
////	  	  	user.setJobDescription(jobRole);
//	  	  	if(dPassword.equals(hPassword)){
//	  	  		userAccount user = new userAccount();
//	  	  		user.setJobDescription(jobDescription);
//	  	  		return user;
//	  	  	} 	
//	    }
//	    return  null;
//		  
//	} 
}
