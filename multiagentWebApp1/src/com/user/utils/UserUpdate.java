package com.user.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c.beans.user;

public class UserUpdate {
	public class ControllerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private UserDAO userDAO;
		public void init() {
			String jdbcURL = getServletContext().getInitParameter("jdbcURL");
			String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
			String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
			userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
			}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
		switch (action) {
		case "/new":
		showNewForm(request, response);
		break;
		case "/insert":
		insertUser(request, response);
		break;
		case "/delete":
		deleteUser(request, response);
		break;
		case "/edit":
		showEditForm(request, response);
		break;
		case "/update":
		updateUser(request, response);
		break;
		default:
		listUser(request, response);
		break;
		}
		} catch (SQLException ex) { 
			throw new ServletException(ex);
			}
		}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		private void listBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			List<user> listUser = userDAO.listAllUsers();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
			dispatcher.forward(request, response);
		}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
		dispatcher.forward(request, response);
		}

		private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		user existingUser = userDAO.getuser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
		request.setAttribute("book", existingUser);
		dispatcher.forward(request, response);
		}
		
		private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
	    int adminOrUser =Integer.parseInt(request.getParameter("adminOrUser"));
		
		user newUser = new user();
		userDAO.insertUser(newUser);
		response.sendRedirect("user");
		}
		
		private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int adminOrUser =Integer.parseInt(request.getParameter("adminOrUser"));
		user newUser = new user();
		userDAO.updateUser(newUser);
		response.sendRedirect("user");
		}
		
		private void deleteUer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		user newUser = new user();
		userDAO.deleteUser(newUser);
		response.sendRedirect("user");
		}
	}
}
