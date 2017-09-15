package com.wedding.datebase.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wedding.database.DBManager;
import com.wedding.entity.Discount;



public class DiscountDao extends DBManager{
	public List<Discount> loadByPage(int page,int displayCount)throws SQLException{
		List<Discount> discountList=new ArrayList<>();
		Connection conn=this.openConnection();
		String sql="select * from Discount limit ?,?";
		Object[] obs= {page*displayCount,displayCount};
		ResultSet rs=this.query(conn, sql, obs);
		while(rs.next()) {
			Discount d=new Discount();
			d.setDiscountId(rs.getInt("discountId"));
			d.setDiscountOnlineTime(rs.getString("discountOnlineTime"));
			d.setProductId(rs.getInt("productId"));
			d.setDiscountPrice(rs.getDouble("discountPrice"));
			d.setDiscountMinPrice(rs.getDouble("discountMinPrice"));
			d.setDiscountCount(rs.getInt("discountCount"));
			d.setDiscountDownLimitTime(rs.getString("discountDownLimitTime"));
			d.setDiscountUpLimitTime(rs.getString("discountUpLimitTime"));
			
			discountList.add(d);
		}
		return discountList;
	}
	
	public int getMaxCount() throws SQLException{
		int maxCount=0;
		Connection conn=this.openConnection();
		String sql="select count(discountId) from Discount";
		ResultSet rs=this.query(conn, sql, null);
		if(rs.next()) {
			maxCount=rs.getInt(1);
		}
		return maxCount;
	}
	
	private String concatSql(String...deleteDiscounts) {
		String sql="delete from discount where discountId in(";
		for (int i = 0; i < deleteDiscounts.length; i++) {
			sql+=i==deleteDiscounts.length-1?deleteDiscounts[i]:deleteDiscounts[i]+",";
		}
		sql+=")";
		return sql;
	}
	
	public int delete(String...deleteDiscounts)throws SQLException{
		Connection conn=this.openConnection();
		String sql=concatSql(deleteDiscounts);
		int count=this.update(conn, sql, null);
		return count;
	}

}
