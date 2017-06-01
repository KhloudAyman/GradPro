package com.user.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.connection.mySQLConnUtils;

/**
 * Servlet implementation class UserDoDelete
 */
//@WebServlet("/UserDoDelete")
public class UserDoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = null;
		System.out.println("inside delete");
		String tempID = request.getParameter("userID");
		System.out.println("id "+tempID);
		int id = Integer.parseInt(tempID);
		UserUtils ud = new UserUtils();
		ud.delete(id);
//		try {
//			Connection conn = mySQLConnUtils.getMySQLConnection();
////			System.out.println(ud.checkIfAdmin(conn, session.get, password));
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		request.setAttribute("delete?id", UserUtils.delete(id));
		response.sendRedirect("UserDelete");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
