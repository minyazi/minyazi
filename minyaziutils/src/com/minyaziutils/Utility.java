package com.minyaziutils;

import org.apache.log4j.Logger;

/**
 * 工具类<br>
 * 
 * @author minyazi
 */
public class Utility {
	
	private static final Logger logger = Utility.getLogger(Utility.class.getName());
	
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
	
	/**
	 * 记录INFO日志<br>
	 * 
	 * @param message 日志
	 */
	public static void infoLog(String message) {
		logger.info(message);
	}
	
	/**
	 * 记录ERROR日志<br>
	 * 
	 * @param message 日志
	 */
	public static void errorLog(String message) {
		logger.error(message);
	}
	
	/**
	 * 记录ERROR日志<br>
	 * 
	 * @param message 日志
	 * @param e 异常
	 */
	public static void errorLog(String message, Exception e) {
		logger.error(message, e);
	}
	
}
