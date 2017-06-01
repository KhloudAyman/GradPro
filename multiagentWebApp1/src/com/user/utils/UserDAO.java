package com.user.utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import c.beans.user;

public class UserDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private java.sql.Connection jdbcConnection;
	
	public UserDAO (String jdbcURL,String jdbcUsername,String jdbcPassword){
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;

	}
	
	protected void connect() throws SQLException {
		if(jdbcConnection == null || jdbcConnection.isClosed()){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUsername , jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertUser(user user) throws SQLException {
		String sql = "INSERT INTO user (name,email,password,phone,adminOrUser) VALUES (?,?,?,?,?)";
		connect();
		
		PreparedStatement st = jdbcConnection.prepareStatement(sql);
		st.setString(1,user.getname());
		st.setString(2,user.getemail());
		st.setString(3,user.getpassword());
		st.setString(4,user.getphone());
		st.setString(5, user.getadminOrUser());
		
		boolean rowInserted = st.executeUpdate() > 0;
		st.close();
		disconnect();
		return rowInserted;
	}
	
	public List<user> listAllUsers() throws SQLException {
		List<user> listUser = new ArrayList<>();
		String sql = "SELECT * FROM user";
		connect();
		
		Statement statement = (Statement) jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			int id = resultSet.getInt("userID");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String phone = resultSet.getString("phone");
			String adminOrUser = resultSet.getString("adminOrUser");
			
		user user = new user();
		listUser.add(user);
		}
		resultSet.close();
		statement.close();
		disconnect();
		return listUser;	
	}
	public boolean deleteUser(user user) throws SQLException {
		String sql = "DELETE FROM user where userID = ?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, user.getuserID());
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
		}
	
	public boolean updateUser(user user) throws SQLException {
		String sql = "UPDATE user SET name = ?, email = ?, password = ?, phone = ? , adminOrUser = ?";
		sql += " WHERE userID = ?";
		connect();
	
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, user.getuserID());
		statement.setString(2, user.getname());
		statement.setString(3, user.getpassword());
		statement.setString(4, user.getphone());
		statement.setString(5, user.getadminOrUser());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
		}
	
	public user getuser(int id)throws SQLException {
		user user = null;
		String sql = "SELECT * FROM user WHERE userID = ?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String phone = resultSet.getString("phone");
			String adminOrUser = resultSet.getString("adminOrUser");
			user user1 = new user();

		}
		resultSet.close();
		statement.close();

		return user;
		}
}
