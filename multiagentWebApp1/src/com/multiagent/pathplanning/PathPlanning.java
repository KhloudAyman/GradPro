package com.multiagent.pathplanning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PathPlanning {
	
	public static void writeInFile(String filePath, String data){
		FileWriter fop = null;
		File file;
		try {

			file = new File(filePath);
			fop = new FileWriter(file);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
//			String s = data.toString();
			// get the content in bytes
//			byte[] contentInBytes = sb.getBytes();
			fop.write(data);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void pathForRobot(String pathOfExE) throws IOException{
		StringBuilder sb = new StringBuilder();
		Process process = Runtime.getRuntime().exec(pathOfExE);
	}
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub		
//		System.out.println("Running");
//		String pathOfExE  = "F:\\ACMTraining2017\\PathPlanning\\Debug\\PathPlanning.exe";
//		String filePath = "F:\\Gradproject\\practice\\RunEXEFile\\file1.txt";
//		pathForRobot(pathOfExE);
//		System.out.println("Done");
//	}
}
