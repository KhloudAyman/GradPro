package db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hash.HashFunctions;

import c.beans.robot;
import c.beans.user;
import db.connection.mySQLConnUtils;


public class dbUtils {
	
//	  PUBLIC STATIC USERACCOUNT FINDUSER(CONNECTION CONN, STRING USERNAME, STRING PASSWORD) THROWS SQLEXCEPTION {
//		  
//	      STRING SQL = "SELECT A.USERNAME, A.USER_PASSWORD FROM USER_TABLE A WHERE A.USERNAME = ? AND A.USER_PASSWORD= ?";
//	 
//	      
//	      PREPAREDSTATEMENT PSTM = CONN.PREPARESTATEMENT(SQL);
//	      PSTM.SETSTRING(1, USERNAME);
//	      PSTM.SETSTRING(2, PASSWORD);
//	      RESULTSET RS = PSTM.EXECUTEQUERY();
//	 
//	      IF (RS.NEXT()) {
//	          USERACCOUNT USER = NEW USERACCOUNT();
//	          USER.SETUSERNAME(USERNAME);
//	          USER.SETPASSWORD(PASSWORD);
//	          RETURN USER;
//	      }
//	      RETURN NULL;
//	  }
	  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static String preparePassword(String password, String email){
		String saltPassword = password+email;
		String hashedPassword = HashFunctions.getHash(saltPassword.getBytes(), "SHA-256");
		return hashedPassword;
	}
	
	  public static user findUser(Connection conn, String username, String password) throws SQLException {
	
		  System.out.println("hello Find user");
//	      String sql = "Select a.user_email from user_table a where ( a.username = ? or a.user_email=? )  and a.user_password= ?";
//		  String sql = "Select * from user_table a where  a.username = ?   and a.user_password= ?";
		  String sql = "Select * from multiagent.user a where ( a.name = ? or a.email=? )";
		  
//		  String sql = "Select a.username from user_table a where a.username ='"+ username+"'  and a.user_password= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, username);
	      pstm.setString(2, username);
//	      pstm.setString(2, password);
	          
	      ResultSet rs = pstm.executeQuery();
	      
	      if (rs.next()) {
	    	  
		      String hEmail = rs.getString(3);
		      String dbPassword = rs.getString(4);
//		      String jobRole = rs.getString(6);
		      String hPassword = preparePassword(password, hEmail);
		      
		      System.out.println("dbPassword"+dbPassword);
		      System.out.println("hPassword"+hPassword);
		      
		      if(dbPassword.equals(hPassword)){
		    	  String phone = rs.getString("phone");
		    	  user user = new user();
		          user.setname(username);
		          user.setpassword(hPassword);
		          user.setemail(hEmail);
		          user.setphone(phone);
		          System.out.println("hello Find user"); //+jobRole);
		          return user;
		          
		      }
	      }
	      
	      
	      return null;
	  }
	  
	  
//	  public static void main(String[] args) throws ClassNotFoundException, SQLException{
//		  
//		  Connection conn = null;
//		  conn = mySQLConnUtils.getMySQLConnection();
//		  userAccount u = findUser(conn, "aya", "aya");
//	  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	  //i think this is will be called if the user enter a username only
	  
	  public static user findUser(Connection conn, String userName) throws SQLException {
			 
	      String sql = "Select a.name, a.password from multiagent.user as a " + " where a.name = ? ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, userName);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          String password = rs.getString("password");
	          user user = new user();
	          user.setname(userName);
	          user.setpassword(password);
	          return user;
	      }
	      return null;
	  }
	  
	  public static int findAdmin(Connection conn,String username,String email,String password1) throws SQLException {
			 
	      String sql = "UPDATE multiagent.user SET password=? WHERE name=? and email=? and adminOrUser='admin'; ";
	     // String hashedPassword = preparePassword(password1,email);
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(2, username);
	      pstm.setString(1, password1);
	      pstm.setString(3, email);
	      int rs = pstm.executeUpdate();
	 
//	      if (rs.next()) {
//	          String password = rs.getString("password1");
//	          user user = new user();
//	          user.setpassword(password);
//	          return 1;
//	      }
	      return rs;
	  }
	  
	  
	  public static int robotRegister (Connection conn,String robotIP, int xLocation, int yLocation, float maxLoad) throws SQLException {
		  
		  String sql ="INSERT INTO multiagent.robot (robot_x, robot_y, robot_maxLoad,robotIP) VALUES(?,?,?,?)" ;
		  PreparedStatement  pstm = conn.prepareStatement(sql);
		  pstm.setInt(1, xLocation);
		  pstm.setInt(2, yLocation);
		  pstm.setFloat(3, maxLoad);
		  pstm.setString(4, robotIP);
		  int result =pstm.executeUpdate();
		  return result;
	  }
	  
//	  public static int userRegister (Connection conn, String username, String email, String mNumber, String password, String jobDescription) throws SQLException {
//		  
//		  String sql ="INSERT INTO user_table (username, user_email, user_mNumber, user_password, user_jobDescription) VALUES(?,?,?,?,?)" ;
//		  String sql1="select count(user_id) from user_table";
//		  int id ;
//		  PreparedStatement idPS = conn.prepareStatement(sql1);
//		  ResultSet rs = idPS.executeQuery();
//		  while (rs.next()) {
//	    	  id = rs.getInt(1);
//	    	  
////		  int i = idPS.getMaxRows() +1;
//		  String sID = Integer.toString(id);
//		  String saltPassword = password+sID+"*1#";
//		  String hashedPassword = HashFunctions.getHash(saltPassword.getBytes(), "SHA-256");
//		  
//		  PreparedStatement  pstm = conn.prepareStatement(sql);
//		  pstm.setString(1, username);
//		  pstm.setString(2, email);
//		  pstm.setString(3, mNumber);
//		  pstm.setString(4, hashedPassword);
//		  pstm.setString(5, jobDescription);
//		  int result =pstm.executeUpdate();
//		  return result;
//		  }
//		  return (Integer) null;
//	  }
	  
	  public static int userRegister (Connection conn, String username, String email, String password, String mNumber, String admin) throws SQLException {
		  
		  String sql ="INSERT INTO multiagent.user (name, email, password, phone, adminOrUser) VALUES(?,?,?,?,?)" ;
//		  int iPassword = Integer.parseInt(password);
//		  String 
		  String hashedPassword = preparePassword(password,email);
//		  String saltPassword = password+email;
//		  String hashedPassword = HashFunctions.getHash(password.getBytes(), "SHA-256");
		  
		  PreparedStatement  pstm = conn.prepareStatement(sql);
		  pstm.setString(1, username);
		  pstm.setString(2, email);
		  pstm.setString(4, mNumber);
//		  pstm.setString(4, password);
		  pstm.setString(3, hashedPassword);
		  pstm.setString(5, admin);
		  int result =pstm.executeUpdate();
		  return result;
	  }

}