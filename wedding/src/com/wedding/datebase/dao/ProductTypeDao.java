package com.wedding.datebase.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wedding.database.DBManager;
import com.wedding.entity.ProductType;

public class ProductTypeDao extends DBManager{
	public List<ProductType> loadByPage(int page,int displayCount) throws SQLException{
		List<ProductType> productTypeList=new ArrayList<>();
		Connection conn =this.openConnection();
		String sql="select * from productType limit ?,?";
		Object[] obs={page*displayCount,displayCount};
		ResultSet rs=this.query(conn, sql, obs);
		while(rs.next()){
			ProductType productType=new ProductType();
			productType.setProductTypeId(rs.getInt("productTypeId"));
			productType.setProductTypeName(rs.getString("productTypeName"));
			productType.setProductTypeCount(rs.getInt("productTypeCount"));
			
			productTypeList.add(productType);
		}
		return productTypeList;
	}
	
	public int getMaxCount() throws SQLException{
		int maxCount=0;
		Connection conn=this.openConnection();
		String sql="select count(productTypeId) from productType";
		ResultSet rs=this.query(conn, sql, null);
		if(rs.next()) {
			maxCount=rs.getInt(1);
		}
		return maxCount;
	}
	
	/** 增加商品分类
	 * @param productType
	 * @return
	 * @throws SQLException
	 */
	public int save(ProductType productType) throws SQLException{
		Connection conn=this.openConnection();
		String sql="insert into ProductType values(default,?,?)";
		Object[] obs={productType.getProductTypeName(),productType.getProductTypeCount()};
		return this.update(conn, sql, obs);		
	}
	
	
	public int SelectProductTypeNameById(String productTypeName) throws SQLException{
		int productTypeId=0;
		Connection conn=this.openConnection();
		String sql="select ProducttypeId from Producttype where ProducttypeName=?";
		Object[] obs= {productTypeName};
		ResultSet res=this.query(conn, sql, obs);
		if(res.next()){
			productTypeId=res.getInt(1);
		}
		return productTypeId;
		
	}

}
