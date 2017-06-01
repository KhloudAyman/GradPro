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

import db.connection.mySQLConnUtils;
import serv.robot.RobotUtils;

/**
 * Servlet implementation class UserDoEdit
 */
@WebServlet("/UserDoEdit")
public class UserDoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDoEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String Ids=(String) request.getParameter("UserId");
		int Id=Integer.parseInt(Ids.trim());
		System.out.println("id "+Id);
		int i=0;
		String name = request.getParameter("username") ;
		String email = request.getParameter("userEmail") ;
		String phone = request.getParameter("usermNumber") ;
		String password = request.getParameter("userPassword") ;
		String adminOrUser = request.getParameter("userJobDescription") ;
		
		Connection conn = null;
	
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
			i = UserUtils.UpdateUser( conn,Id, name, email, phone, password,adminOrUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(i>0){
       		 RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/UserUpdate1");

                dispatcher.forward(request, response);
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
