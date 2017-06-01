package com.multiagent.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientThread implements Runnable {
	
	private Socket socket;
	boolean running = true;
	

	public ClientThread(Socket socket) {
		this.socket = socket;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataInputStream in = null;
		DataOutputStream out = null;
		String data="";
	
		 
		 
		 
		 try {
			  in = new DataInputStream(socket.getInputStream());
			  out = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println("in or out failed");
		}
		 
	
		      try{
		    	  while (running ) {
		    		  data = in.readUTF();
		    		  if (data == null) {
							continue;
						}
				      System.out.println("'"+data +"'"+ " from " + socket.getInetAddress()+":"+socket.getPort()
				        + " on port " + socket.getLocalPort());
				    
				      
				     if (data.equalsIgnoreCase("done")) {
						running = false;
						Server.clientNum--;
						System.out.println("*** Stopping client thread for client : " + socket.getRemoteSocketAddress()+" ***");
						System.out.println("*** number of clients "+Server.clientNum + "***");
					}
		    	  }
		       }catch (IOException e) {
		    	   e.printStackTrace();
		        System.out.println("Read failed");
		        
		       }
		      finally {
				try {
					socket.close();
					in.close();
					out.close();
					System.out.println("...Stopped"); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		   
		 
		
	
		 
	}

	
	

	
	

}
