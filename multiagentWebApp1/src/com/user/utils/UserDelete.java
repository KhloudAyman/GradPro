package com.user.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import c.beans.robot;
import c.beans.user;
import db.connection.mySQLConnUtils;
import serv.robot.RobotUtils;

/**
 * Servlet implementation class UserDoUpdate
 */
//@WebServlet("/userDoDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		Connection conn = null;
		List<user> userData = null;
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
			userData = new UserUtils().getUserData(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello Delete User");

//		RequestDispatcher dispatcher2 ;
//		HttpSession session = request.getSession();
//		if(session.getAttribute("loginedUser") != null){
////			System.out.println(session.getAttribute("loginedUser"));
//			session.invalidate();
//			dispatcher2 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/usersDelete.jsp");
////	        = this.getServletContext().getRequestDispatcher("/test");
//	        dispatcher2.forward(request, response);
//		}
//		else{
//			session.invalidate();
////			System.out.println(session.getAttribute("loginedUser"));
//			dispatcher2 = this.getServletContext().getRequestDispatcher("/index.jsp");
//		}
		
		request.setAttribute("userData", userData);
		request.getRequestDispatcher("/WEB-INF/views/usersDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
