package com.minyaziutils;

import java.util.Locale;
import java.util.UUID;

/**
 * 字符串工具类<br>
 * 
 * @author minyazi
 */
public class StringUtil {
	
	/**
	 * 获取一个UUID<br>
	 * 
	 * @return 返回一个UUID。
	 */
	public static String getUUID() {
        return UUID.randomUUID().toString();
    }
	
	/**
	 * 获取一个小写的UUID<br>
	 * 
	 * @return 返回一个转换为小写的UUID。
	 */
	public static String getLowerUUID() {
        return getUUID().toLowerCase(Locale.ENGLISH);
    }
	
	/**
	 * 获取一个大写的UUID<br>
	 * 
	 * @return 返回一个转换为大写的UUID。
	 */
	public static String getUpperUUID() {
        return getUUID().toUpperCase(Locale.ENGLISH);
    }
	
	/**
	 * 格式化null字符串<br>
	 * 
	 * @param value 要格式化的String
	 * @return 如果String等于null，则返回空字符串，否则返回String本身。
	 */
	public static String formatNullString(String value) {
		LogUtil.debug("String：" + value);
		return value == null ? "" : value;
	}
	
	/**
	 * 格式化null金额<br>
	 * 
	 * @param value 要格式化的Amount
	 * @return 如果Amount等于null或空字符串，则返回null，否则返回Amount本身。
	 */
	public static String formatNullAmount(String value) {
		LogUtil.debug("Amount：" + value);
		return (value == null || value.trim().equals("")) ? null : value;
	}
	
}
