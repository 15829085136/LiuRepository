package com.wedding.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configuration {
	private static Logger logger=Logger.getLogger(Configuration.class);
	private static String configFilePath="/db.properties";
	private static Properties properties;
	static {
		InputStream inStream=Configuration.class.getResourceAsStream(configFilePath);
		if(inStream!=null) {
			properties=new Properties();
			try {
				properties.load(inStream);
			} catch (IOException e) {
				logger.debug(e.getMessage());
			}
		}
	}
	
	private static void rebuilder() {
		InputStream inStream=Configuration.class.getResourceAsStream(configFilePath);
		if(inStream!=null) {
			properties=new Properties();
			try {
				properties.load(inStream);
			} catch (IOException e) {
				logger.debug(e.getMessage());
			}
		}
	}
	
	public static String getProperty(String property) {
		if(properties==null)
			rebuilder();
		return properties.getProperty(property);
	}
}

