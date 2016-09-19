package com.minyaziutils;

import org.apache.log4j.Logger;

/**
 * 工具类<br>
 * 
 * @author minyazi
 */
public class Utility {
	
	/**
	 * 获取日志记录器<br>
	 * 
	 * @param name 日志记录器名称
	 * @return 日志记录器
	 */
	public static Logger getLogger(String name) {
		// Apache log4j 1.2.17
		return Logger.getLogger(name);
		
		// Apache log4j 2.2
//		return LogManager.getLogger(name);
	}
	
}
