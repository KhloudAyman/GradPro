package com.multiagent.contextListener;

import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.multiagent.server.Server;

//import com.multiagent.serverCode.Server;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
//          TODO Auto-generated method stub
    	
 
    	Thread t = new Thread(new Runnable(){
    	    @Override
    	    public void run() {
    	    	Server server = new Server();
    	    	server.listen();
    	    }
    	});
    	t.start();
    	System.out.println("########################################################");
    }
	
}
