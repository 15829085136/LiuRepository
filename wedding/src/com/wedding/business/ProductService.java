package com.wedding.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.wedding.datebase.dao.ProductDao;
import com.wedding.entity.Product;


public class ProductService {
	private ProductDao productDao=new ProductDao();
	private Logger logger=Logger.getLogger(ProductService.class);
	public List<Product> loadByPage(int page,int displayCount){
		List<Product> productList=null;
		try {
			productList=productDao.loadByPage(page, displayCount);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return productList;
	}
	
	public int calctorMaxPage(int displayCount) {
		int maxPage=0;
		try {
			int maxCount=productDao.getMaxCount();
			maxPage=maxCount%displayCount==0?maxCount/displayCount:maxCount/displayCount+1;
		} catch (SQLException e) {
			logger.debug(e.getMessage());
		}
		return maxPage-1;
		//maxPage-1
	}
	
	public boolean save(Product product) {
		boolean bool=false;
		try {
			int count=productDao.save(product);
			if(count>0)
				bool=true;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return bool;
	}
	
	public boolean delete(String...deleteProducts) {
		boolean bool=false;
		try {
			
			int count=productDao.delete(deleteProducts);
			if(count>0)
				bool=true;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return bool;
	}
	
	public Product loadUpdate(int productId){
		Product product=null;
		try {
			product=productDao.loadUpdate(productId);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return product;
	}

	public boolean update(Product product) {
		boolean bool=false;
		try {
			int count=productDao.update(product);
			if(count>0)
				bool=true;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return bool;
	}

}
