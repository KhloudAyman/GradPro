package serv.robot;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoEditRobot
 */
@WebServlet("/DoEditRobot")
public class DoEditRobot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditRobot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("id "+ request.getParameter("RobotId"));
		String Ids=(String) request.getParameter("RobotId");
		System.out.println("id "+Ids);
		int Id=Integer.parseInt(Ids.trim());
		System.out.println("id "+Id);
		
		
		String robotIP = request.getParameter("RobotIP") ;
		String xLocationS = request.getParameter("x_location") ;
		String yLocationS = request.getParameter("y_location") ;
		String maxLoadS = request.getParameter("max_load") ;
		
		int xLocation = Integer.parseInt(xLocationS);
    	int yLocation = Integer.parseInt(yLocationS);
    	float maxLoad = Float.parseFloat(maxLoadS);
		int i=RobotUtils.updateRobot( Id ,robotIP,  xLocation, yLocation, maxLoad);
		 if(i>0){
       		 RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/RobotUpdate");

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
