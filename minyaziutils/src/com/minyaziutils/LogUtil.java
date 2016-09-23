package com.minyaziutils;

import org.apache.log4j.Logger;

/**
 * 日志工具类<br>
 * 
 * @author minyazi
 */
public class LogUtil {
	
	private static final Logger LOGGER = Logger.getLogger(LogUtil.class.getName());
	
	/**
	 * 用给定的名称构造日志记录器<br>
	 * 
	 * @param name 日志记录器名称
	 * @return 返回指定名称的日志记录器。
	 */
	public static Logger getLogger(String name) {
		debug("日志记录器名称：" + name);
		if (StringUtil.isEmptyString(name)) {
			return LOGGER;
		} else {
			// Apache log4j 1.2.17
			return Logger.getLogger(name);
			
			// Apache log4j 2.2
//			return LogManager.getLogger(name);
		}
	}
	
	/**
	 * 记录DEBUG日志<br>
	 * 
	 * @param message 日志
	 */
	public static void debug(Object message) {
		LOGGER.debug(message);
	}
	
	/**
	 * 记录INFO日志<br>
	 * 
	 * @param message 日志
	 */
	public static void info(Object message) {
		LOGGER.info(message);
	}
	
	/**
	 * 记录ERROR日志<br>
	 * 
	 * @param message 日志
	 */
	public static void error(Object message) {
		LOGGER.error(message);
	}
	
	/**
	 * 记录异常日志<br>
	 * 
	 * @param e 异常
	 */
	public static void exception(Exception e) {
		LOGGER.error(e.getMessage(), e);
	}
	
}
