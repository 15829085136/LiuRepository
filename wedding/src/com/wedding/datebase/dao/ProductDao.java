package com.wedding.datebase.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wedding.database.DBManager;
import com.wedding.entity.Product;

public class ProductDao extends DBManager{
	public List<Product> loadByPage(int page,int displayCount)throws SQLException{
		List<Product> productList=new ArrayList<>();
		Connection conn=this.openConnection();
		String sql="select * from Product limit ?,?";
		Object[] obs= {page*displayCount,displayCount};
		ResultSet rs=this.query(conn, sql, obs);
		while(rs.next()) {
			Product p=new Product();
			p.setProductId(rs.getInt("ProductId"));
			p.setProductName(rs.getString("ProductName"));
			p.setProductInPrice(rs.getDouble("ProductInPrice"));
			p.setProductOutPrice(rs.getDouble("ProductOutPrice"));
			p.setProductStoreCount(rs.getInt("ProductStoreCount"));
			p.setProductSellCount(rs.getInt("ProductSellCount"));
			
			
			productList.add(p);
		}
		return productList;
	}
	
	public int getMaxCount() throws SQLException{
		int maxCount=0;
		Connection conn=this.openConnection();
		String sql="select count(ProductId) from product";
		ResultSet rs=this.query(conn, sql, null);
		if(rs.next()) {
			maxCount=rs.getInt(1);
		}
		return maxCount;
	}
	
	public int save(Product product)throws SQLException{
		Connection conn=this.openConnection();
		String sql="insert into product values(?,?,?,?,?,?,?)";
		Object[] obs= {product.getProductId(),product.getProductName(),product.getProductInPrice(),product.getProductOutPrice(),product.getProductStoreCount(),product.getProductSellCount(),product.getProductTypeId()};
		return this.update(conn, sql, obs);
	}
	
	private String concatSql(String...deleteProducts) {
		String sql="delete from Product where ProductId in(";
		for (int i = 0; i < deleteProducts.length; i++) {
			sql+=i==deleteProducts.length-1?deleteProducts[i]:deleteProducts[i]+",";
		}
		sql+=")";
		return sql;
	}
	
	public int delete(String...deleteProducts)throws SQLException{
		Connection conn=this.openConnection();
		String sql=concatSql(deleteProducts);
		int count=this.update(conn, sql, null);
		return count;
	}
	
	public Product loadUpdate(int productId)throws SQLException{
		Product product=null;
		Connection conn=this.openConnection();
		String sql="select * from product where productId=?";
		Object[] obs= {productId};
		ResultSet rs=this.query(conn, sql, obs);
		if(rs.next()) {
			product=new Product();
			product.setProductId(rs.getInt("ProductId"));
			product.setProductName(rs.getString("ProductName"));
			product.setProductInPrice(rs.getDouble("ProductInPrice"));
			product.setProductOutPrice(rs.getDouble("ProductOutPrice"));
			product.setProductStoreCount(rs.getInt("ProductStoreCount"));
			product.setProductSellCount(rs.getInt("ProductSellCount"));
			product.setProductTypeId(rs.getInt("ProducttypeId"));
		
		}
		return product;
	}
	
	public int update(Product product)throws SQLException{
		Connection conn=this.openConnection();
		String sql="update Product set ProductId=?,ProductName=?,ProductInPrice=?,ProductOutPrice=?,ProductStoreCount=?,ProductSellCount=? where ProductId=?";
		Object[] obs= {product.getProductId(),product.getProductName(),product.getProductInPrice(),product.getProductOutPrice(),product.getProductStoreCount(),product.getProductSellCount()};
		return this.update(conn, sql, obs);
	}

}
