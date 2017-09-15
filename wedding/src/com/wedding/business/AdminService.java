package com.wedding.business;
import org.apache.log4j.Logger;

import com.wedding.datebase.dao.AdminDao;
import com.wedding.entity.Admin;
public class AdminService {
		private AdminDao adminDao=new AdminDao();
		private Logger logger=Logger.getLogger(AdminService.class);
		
		
		public boolean checkAdmin(Admin a) {
			boolean bool=false;
			try {
				Admin admin=adminDao.loadAdmin(a);
				if(admin!=null) {
					bool=true;
				}
			} catch (Exception e) {
				logger.debug(e.getMessage());
			}
			return bool;
		}
}
