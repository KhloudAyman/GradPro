package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.authentication.Authentication;
import com.user.utils.UserUtils;

import c.beans.user;
import db.connection.mySQLConnUtils;
import db.utils.MyUtils;
import db.utils.dbUtils;

/**
 * Servlet implementation class userDologin
 */
@WebServlet("/UserDologin")
public class userDologin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	public static int flagLogin=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDologin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		Connection conn = mySQLConnUtils.getMySQLConnection();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user user = null;
//        userAccount user = new userAccount();
        boolean hasError = false;
        String errorString = null;
//        String email = user.getEmail();
        Connection conn = null;
        
 
        
        if (username == null || password == null
                || username.length() == 0 || password.length() == 0) {
           hasError = true;
           errorString = "Required username and password!";
           // Forward to /WEB-INF/views/login.jsp
           
        } 
        
        else{
    	   try {
       		conn =mySQLConnUtils.getMySQLConnection();
       		request.setAttribute(ATT_NAME_CONNECTION, conn);
       		Connection conn1 = MyUtils.getStoredConnection(request);
       		//dbUtils.userRegister(conn1, "khloud", "khloud@gmail.com", "khloud", "01010101010", "1");
       		user = dbUtils.findUser(conn1, username, password);
       		
     		//String name = Authentication.checkUniqueUsername(conn1, username);
     		//System.out.println(name);
       		if(user != null){
       			hasError = false;
       		}
       		else{
       			hasError = true;
       			errorString = "User Name or password invalid";
       			
       			
       		}
       		
       		
//       		userAccount us = UserUtils.checkIfAdmin(conn1, username, password);
       		
       		
    	   }catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		   }catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	   
       }
        if(hasError){
        	request.setAttribute("errorString", errorString);
        	RequestDispatcher dispatcher3
        	= this.getServletContext().getRequestDispatcher("/index.jsp");
        	dispatcher3.forward(request, response);
        }
        else{
        	
     	   HttpSession session = request.getSession();
           MyUtils.storeLoginedUser(session, user);
           System.out.println(session.getAttribute("loginedUser"));
    	   request.setAttribute("user", user);
           RequestDispatcher dispatcher2 
           = this.getServletContext().getRequestDispatcher("/HomePage");
           dispatcher2.forward(request, response);
        	
        }
        
        
        /*
        else {
        	try {
        		conn =mySQLConnUtils.getMySQLConnection();
        		request.setAttribute(ATT_NAME_CONNECTION, conn);
//        		MyUtils.storeConnection(request, conn);
        		

				
//				request.setAttribute(ATT_NAME_CONNECTION, conn);
        		} 
        	catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				} 
        	catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
//       	user = new userAccount();
//       	String email = user.getEmail();
       	//Connection conn=null;
//           Connection conn = MyUtils.getStoredConnection(request);

    		Connection conn1 = MyUtils.getStoredConnection(request);
        	try {
        		
        		System.out.println(conn1);
        		user = dbUtils.findUser(conn1, username, password);
//        		user = dbUtils.findUser(conn, username, password);
        		if (user == null) {
        			hasError = true;
                    errorString = "User Name or password invalid";
                    }
        		} 
        	catch (SQLException e) {
        		e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
                }
        	
     		try {
				userAccount us = UserUtils.checkIfAdmin(conn1, username, password);
//				String status = UserUtils.checkIfAdmin(conn1, username, password);
//	       		System.out.println("Status u");
//	       		System.out.println(status);
		 		String status = us.getjobDescription();
//	     		String status = UserUtils.checkIfAdmin(conn1, username, password);
	       		System.out.println("Status u");
	       		System.out.println(status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//       		userAccount us = new userAccount();
//       		String status = us.getjobDescription();
//     		String status = UserUtils.checkIfAdmin(conn1, username, password);
//       		System.out.println("Status u");
//       		System.out.println(status);
        	
        	
        	}
       
       // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
           user = new userAccount();
           user.setUsername(username);
           user.setPassword(password);
            
       
           // Store information in request attribute, before forward.
           request.setAttribute("errorString", errorString);
           request.setAttribute("user", user);

      
           // Forward to /WEB-INF/views/login.jsp
           RequestDispatcher dispatcher
           = this.getServletContext().getRequestDispatcher("/error.jsp");

           dispatcher.forward(request, response);
           }
       else{
    	   
  
    	   
    	   HttpSession session = request.getSession();
           MyUtils.storeLoginedUser(session, user);
    	   request.setAttribute("user", user);
           RequestDispatcher dispatcher2 
           = this.getServletContext().getRequestDispatcher("/HomePage");
           dispatcher2.forward(request, response);
//    	   response.sendRedirect(request.getContextPath() + "/taskpanel");

       }
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
