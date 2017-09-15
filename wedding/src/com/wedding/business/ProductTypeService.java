package com.wedding.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.wedding.datebase.dao.ProductTypeDao;
import com.wedding.entity.ProductType;

public class ProductTypeService {
	private ProductTypeDao productTypeDao=new ProductTypeDao();
	private Logger log=Logger.getLogger(ProductTypeService.class); 
	
	public List<ProductType> loadByPage(int page,int displayCount){
		List<ProductType> productTypeList=null;
		try {
			productTypeList=productTypeDao.loadByPage(page, displayCount);
		} catch (SQLException e) {
			 log.debug(e.getMessage());
		}
		return productTypeList;
	}
	

	/**计算最大页数
	 * @param displayCount
	 * @return
	 */
	public int calctorMaxPage(int displayCount) {
		int maxPage=0;
		try {
			int maxCount=productTypeDao.getMaxCount();
			maxPage=maxCount%displayCount==0?maxCount/displayCount:maxCount/displayCount+1;
		} catch (SQLException e) {
			log.debug(e.getMessage());
		}
		return maxPage-1;
	}
	
	public boolean save(ProductType productType){
		boolean bool=false;
		try {
			int count=productTypeDao.save(productType);
			if(count>0){
				bool=true;
			}
		} catch (SQLException e) {
			log.debug(e.getMessage());
		}
		return bool;
	}
	
	
	public int SelectProductTypeNameById(String productTypeName) {
		int productId=0;
		try {
			productId=productTypeDao.SelectProductTypeNameById(productTypeName);
		} catch (SQLException e) {
			log.debug(e.getMessage());	
		}
		return productId;
	}

}
