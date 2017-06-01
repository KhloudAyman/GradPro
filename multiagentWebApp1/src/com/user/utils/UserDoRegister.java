package com.user.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c.beans.user;
import db.connection.mySQLConnUtils;
import db.utils.dbUtils;;

/**
 * Servlet implementation class UserDoRegister
 */
@WebServlet("/UserDoRegister")
public class UserDoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
//		int id = request.getParameter(iID);
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		String mNumber = request.getParameter("usermNumber");
		String jobDescription = request.getParameter("userJobDescription");

		
		boolean hasError = false;
		String errorString;
		user user = null;
		Connection conn = null;
		int i=0;
		
        if (username == null || password == null
                || username.length() == 0 || password.length() == 0) {
           hasError = true;
           errorString = "Required username and password!";
       }
        else{
        	try {
				conn = mySQLConnUtils.getMySQLConnection();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try{
        		i = dbUtils.userRegister(conn, username, email, password,mNumber ,  jobDescription);
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	 if(i>0){
    		 RequestDispatcher dispatcher
             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homePage.jsp");

             dispatcher.forward(request, response);
    	 }
        }
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
