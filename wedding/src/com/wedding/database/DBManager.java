package com.wedding.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wedding.tools.Configuration;

public abstract class DBManager {
	private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
	static {
		String driverClass=Configuration.getProperty("connection.driverClass");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection openConnection()throws SQLException {
		Connection conn=threadLocal.get();
		if(conn==null) {
			String url=Configuration.getProperty("connection.url");
			String user=Configuration.getProperty("connection.user");
			String password=Configuration.getProperty("connection.password");
			conn=DriverManager.getConnection(url,user,password);
			threadLocal.set(conn);
		}
		return conn;
	}
	
	public void closeConnection() throws SQLException{
		Connection conn=threadLocal.get();
		if(conn!=null) {
			conn.close();
			threadLocal.set(null);
		}
	}
	
	public int update(Connection conn,String sql,Object...obs)throws SQLException{
		int count=0;
		if(conn!=null && !conn.isClosed()) {
			PreparedStatement psment=conn.prepareStatement(sql);
			if(obs!=null) {
				for (int i = 0; i < obs.length; i++) {
					psment.setObject(i+1, obs[i]);
				}
			}
			count=psment.executeUpdate();
		}
		return count;
	}
	
	public ResultSet query(Connection conn,String sql,Object...obs)throws SQLException{
		ResultSet rs=null;
		if(conn!=null && !conn.isClosed()) {
			PreparedStatement psment=conn.prepareStatement(sql);
			if(obs!=null) {
				for (int i = 0; i < obs.length; i++) {
					psment.setObject(i+1, obs[i]);
				}
			}
			rs=psment.executeQuery();
		}
		return rs;
	}
}

