package com.wedding.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wedding.datebase.dao.DiscountDao;
import com.wedding.entity.Discount;


public class DiscountService {
	private DiscountDao discountDao=new DiscountDao();
	private Logger logger=Logger.getLogger(DiscountService.class);
	public List<Discount> loadByPage(int page,int displayCount){
		List<Discount> discountList=new ArrayList();
		try {
			discountList=discountDao.loadByPage(page, displayCount);	
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return discountList;
	}
	
	public int calctorMaxPage(int displayCount){
		int maxPage=0;
		try {
			int maxCount=discountDao.getMaxCount();
			maxPage=maxCount%displayCount==0?maxCount/displayCount:maxCount/displayCount+1;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return maxPage;
	}
	
	public boolean delete(String...deleteDiscounts) {
		boolean bool=false;
		try {
			
			int count=discountDao.delete(deleteDiscounts);
			if(count>0)
				bool=true;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return bool;
	}
	

}
