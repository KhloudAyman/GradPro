package com.task.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskUtils {
	
		
		public static int taskRegister(Connection conn, float load, int startX, int startY, int endX, int endY, String taskname) throws SQLException{
			
			String sql = "INSERT INTO multiagent.task (taskload, startX, startY, endX, endY, taskname) VALUES(?,?,?,?,?,?);";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setFloat(1, load);
			pstm.setInt(2, startX);
			pstm.setInt(3, startY);
			pstm.setInt(4, endX);
			pstm.setInt(5, endY);
			pstm.setString(6, taskname);
			
			int result =pstm.executeUpdate();
			
			return result;
		
		}


}
