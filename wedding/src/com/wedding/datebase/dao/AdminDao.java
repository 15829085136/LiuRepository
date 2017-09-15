package com.wedding.datebase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wedding.database.DBManager;
import com.wedding.entity.Admin;

import java.sql.Connection;

public class AdminDao extends DBManager{
	public Admin loadAdmin(Admin a)throws SQLException{
		Admin admin=null;
		Connection conn=this.openConnection();
		String sql="select * from admin where AdminName=? and AdminPwd=?";
		Object[] obs={a.getAdminName(),a.getAdminPwd()};
		ResultSet rs=this.query(conn, sql, obs);
		if(rs.next()){
			admin=new Admin();
			admin.setAdminId(rs.getInt("adminId"));
			admin.setAdminName(rs.getString("adminName"));
			admin.setAdminPwd(rs.getString("adminPwd"));
		}
		this.closeConnection();
		return admin;
	}

}
