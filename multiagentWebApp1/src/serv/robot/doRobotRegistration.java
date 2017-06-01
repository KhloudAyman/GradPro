package serv.robot;

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
import db.utils.dbUtils;

/**
 * Servlet implementation class doRobotRegistration
 */
@WebServlet("/doRobotRegistration")
public class doRobotRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doRobotRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String robotIP = request.getParameter("RobotIP") ;
		String xLocationS = request.getParameter("x_location") ;
		String yLocationS = request.getParameter("y_location") ;
		String maxLoadS = request.getParameter("max_load") ;
		
        boolean hasError = false;
        String errorString = null;
        
		
		Connection conn = null;
		int i =0;
		
        if (xLocationS == null || yLocationS == null
                || xLocationS.length() == 0 || yLocationS.length() == 0) {
           hasError = true;
           errorString = "Required Location!";
       }
        else{
        	int xLocation = Integer.parseInt(xLocationS);
        	int yLocation = Integer.parseInt(yLocationS);
        	float maxLoad = Float.parseFloat(maxLoadS);
        	
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
				i = dbUtils.robotRegister(conn,robotIP, xLocation, yLocation, maxLoad);
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
