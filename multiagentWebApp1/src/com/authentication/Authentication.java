package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.connection.mySQLConnUtils;
import db.utils.MyUtils;

// 1 --> "Weak Password" -- "Short Username"
// 2 --> "Good Password" -- "Good Username"
// 3 --> "Strong Password"
// 4 --> "Too long Password" -- "Too long Username"
public class Authentication {
	
	public static int checkPassword(String password){
        int pLength;
        pLength = password.length();
        System.out.println(pLength);
            if (pLength < 6 ){
            return 1;
            }
            if (pLength > 6 && pLength < 11){
            	return 2;
            }
            if (pLength > 200){
            	return 4;
            }
            return 3;
        }
	
	public static int checkUsername(String username){
		int uLength;
		uLength = username.length();
		if(uLength <=3){
			return 1;
		}
		if(uLength > 200){
			return 4;
		}
		return 2;
	}
	
	public static String checkUniqueUsername(Connection conn, String username) throws SQLException{
		String name = null;
		String sql = "Select * from multiagent.user a where a.name = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, username);
	    ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			name = rs.getString(2);
		}
		return name;
	}
	
	
	
public static void main(String[] args) throws SQLException{
	
		Connection conn = null;
		try {
			conn = mySQLConnUtils.getMySQLConnection();
			int tr = checkPassword("8989898gjjhjhghgjgj98");
			int cr = checkUsername("aya");
			String rr = checkUniqueUsername(conn,"toqa");
			System.out.println("p  "+tr);
			System.out.println("u  "+cr);
			System.out.println("conn  "+conn);
			System.out.println("rr  "+rr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute(ATT_NAME_CONNECTION, conn);
//   		Connection conn1 = MyUtils.getStoredConnection(request);
   		
	}
}


