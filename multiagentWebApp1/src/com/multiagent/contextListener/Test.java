package com.multiagent.contextListener;

import com.multiagent.server.ClientSocket;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientSocket sockets = new ClientSocket("127.0.0.1", 8000);
		sockets.send("done");
		sockets.end();
		//sockets.send("done");
		
	}

}
