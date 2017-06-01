package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import c.beans.user;
import db.connection.mySQLConnUtils;

//import com.mysql.jdbc.Connection;

import db.utils.MyUtils;
import db.utils.dbUtils;
import serv.robot.RobotUtils;

/**
 * Servlet implementation class DoForgetPassword
 */
@WebServlet("/DoForgetPassword")
public class DoForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
//System.out.println("inside delete");
		
		boolean hasError = false;
        String errorString = null;
        
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("npassword");
		String hPassword = dbUtils.preparePassword(password, email);
		Connection conn = null;
		 int i =0;
		 System.out.println("username:"+username);
		 System.out.println("email:"+email);
		 System.out.println("password:"+password);

        if (username == null || email == null||password == null
                || username.length() == 0 || email.length() == 0||password.length() == 0) {
           hasError = true;
           errorString = "Data is missing!";
       }else{
       	
       	try {
				conn =mySQLConnUtils.getMySQLConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	 try {
//				dbUtils.robotRegister(conn, xLocation, yLocation, maxLoad);
				i = dbUtils.findAdmin(conn,username,email,hPassword );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	System.out.println("username:"+username);
		 System.out.println("email:"+email);
		 System.out.println("password:"+password);
       	 if(i>0){
       		 RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/index.jsp");

                dispatcher.forward(request, response);
       	 }
       }
        
        
        
//		request.setAttribute("delete?id", UserUtils.delete(id));
//		response.sendRedirect("forgetPassword");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String username = request.getParameter("username");
//    	String email = request.getParameter("email");
//		String password = request.getParameter("password");    
//		response.setContentType("text/plain");
//		    PrintWriter out = response.getWriter();
//
//		    Connection con = null;
//		    try {
//		      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		      con = DriverManager.getConnection("jdbc:odbc:ordersdb", "user", "passwd");
//		      
//
//		      // Turn on transactions
//		      con.setAutoCommit(false);
//
//		      java.sql.Statement stmt = con.createStatement();
//		      stmt.executeUpdate("update user set password=?, where email=? and adminOrUser=1");
//		      ((PreparedStatement) stmt).setString(2, username);
//			  ((PreparedStatement) stmt).setString(4, password);
//			  ((PreparedStatement) stmt).setString(3, email);
//
//		      con.commit();
//		      out.println("You are successfully update");
//		    }
//		    catch (Exception e) {
//		      // Any error is grounds for rollback
//		      try {
//		        con.rollback();
//		      }
//		      catch (SQLException ignored) { }
//		      out.println("You are Unsuccessfully update");
//		    }
//		    finally {
//		      // Clean up.
//		      try {
//		        if (con != null) con.close();
//		      }
//		      catch (SQLException ignored) { }
//		    }
		
		doGet(request, response);
	}

}
