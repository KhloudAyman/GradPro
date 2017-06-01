package com.multiagent.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket serverSocket;
	Socket socket;
	int port = 8000;
	static int clientNum=0;
	
	public void listen(){
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not listen on port: " + port);
		}
		
		while (true) {
			ClientThread client;
			try {
				socket = serverSocket.accept();
				clientNum++;
				System.out.println("*** client "+socket.getRemoteSocketAddress()+" has connected ***");
				System.out.println("***number of clients connected = " + clientNum+" ***");
				client = new ClientThread(socket);
				Thread t = new Thread(client);
			      t.start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Accept failed");
			}
		}
		
		//stop the server
	}
	

}
