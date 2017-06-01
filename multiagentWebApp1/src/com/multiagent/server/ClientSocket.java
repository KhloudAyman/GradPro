package com.multiagent.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientSocket {
	private Socket socket = null;
	private DataOutputStream out = null;
	
	// create socket and output stream 
	public ClientSocket(String ip, int portnum) {

		try {
			this.socket = new Socket(ip, portnum);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("can not connect");
			}
		
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("out problem");
		}

	}
	
	// send data 
	public void send(String data) {
		
		try {
			out.writeUTF(data);
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// terminate socket and output stream 
	public void end(){
		try {
			socket.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	


}

