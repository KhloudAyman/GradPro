package com.task.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multiagent.pathplanning.PathPlanning;
import com.multiagent.server.ClientSocket;
import com.mysql.jdbc.PreparedStatement;

import c.beans.robot;
import db.connection.mySQLConnUtils;

/**
 * Servlet implementation class TaskDoRegister
 */
@WebServlet("/TaskDoRegister")
public class TaskDoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn =null;
		Task task = null;
		int i=0;
		String taskName = request.getParameter("taskName");
		String taskLoadS = request.getParameter("taskLoad");
		String startX = request.getParameter("startLocationX");
		String startY = request.getParameter("startLocationY");
		String endX = request.getParameter("endLocationX");
		String endY = request.getParameter("endLocationY");
		float taskLoadF = Float.parseFloat(taskLoadS);
		int startXI = Integer.parseInt(startX);
		int startYI = Integer.parseInt(startY);
		int endXI = Integer.parseInt(endX);
		int endYI = Integer.parseInt(endY);
		List<Integer> data = new ArrayList<>();
		data.add(startXI);
		data.add(startYI);
		data.add(endXI);
		data.add(endYI);
//		String s = String.
		String dataS = data.toString();
		PathPlanning.writeInFile("D:\\programs\\eclipse\\eclipse\\jee-neon\\eclipse\\eclipse2\\New folder\\multiagentWebApp1\\Input_Start_and_End_Points.txt", dataS);
		PathPlanning.pathForRobot("D:\\programs\\eclipse\\eclipse\\jee-neon\\eclipse\\eclipse2\\New folder\\multiagentWebApp1\\bin\\Debug\\TestPathPlanning.exe");
		
		// read file extract x and y
		try {
			BufferedReader bReader = new BufferedReader(new FileReader("D:\\programs\\eclipse\\eclipse\\jee-neon\\eclipse\\eclipse2\\New folder\\multiagentWebApp1\\Output_Position_matrix.txt"));
			String xString = bReader.readLine();
			String yString = bReader.readLine();
			ClientSocket clientSocket = new ClientSocket("", 8000);
			clientSocket.send(xString);
			clientSocket.send(yString);
			clientSocket.send("done");
			clientSocket.end();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inside do task");
		try {
			conn =mySQLConnUtils.getMySQLConnection();
			i = TaskUtils.taskRegister(conn, taskLoadF, startXI, startYI, endXI, endYI, taskName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0){
			 RequestDispatcher dispatcher
           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homePage.jsp");

           dispatcher.forward(request, response);		}
             
//			else                
//				out.println("Insert Unsuccessful"); 
//		
		System.out.println("do task");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
