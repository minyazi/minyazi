package com.minyaziutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类<br>
 * 
 * @author minyazi
 */
public class DateUtil {
	
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	
	/**
	 * 用给定的日期模式构造SimpleDateFormat对象<br>
	 * 
	 * @param pattern 日期模式
	 * @return 返回指定日期模式的SimpleDateFormat对象。
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern) {
		LogUtil.debug("日期模式：" + pattern);
		if (StringUtil.formatNullString(pattern).trim().equals("")) {
			return new SimpleDateFormat(DEFAULT_PATTERN, Locale.ENGLISH);
		} else {
			return new SimpleDateFormat(pattern, Locale.ENGLISH);
		}
	}
	
	/**
	 * 获取日期<br>
	 * 
	 * @return yyyyMMdd，如:20160101。
	 */
	public static String getDate() {
		return getSimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取时间<br>
	 * 
	 * @return HHmmss，如：010101。
	 */
	public static String getTime() {
		return getSimpleDateFormat("HHmmss").format(new Date());
	}
	
	/**
	 * 获取日期时间<br>
	 * 
	 * @return yyyyMMddHHmmss，如：20160101010101。
	 */
    public static String getDateTime()  {
		return getSimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
    
    /**
     * 获取完整的日期时间<br>
     * 
     * @return yyyyMMddHHmmssSSS，如：20130101010101001。
     */
    public static String getFullDateTime() {
    	return getSimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
    
    /**
	 * 获取ISO日期<br>
	 * 
	 * @return yyyy-MM-dd，如:2013-01-01。
	 */
	public static String getISODate() {
		return getSimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 获取ISO时间<br>
	 * 
	 * @return HH:mm:ss，如：01:01:01。
	 */
	public static String getISOTime() {
		return getSimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	/**
	 * 获取ISO日期时间<br>
	 * 
	 * @return yyyy-MM-dd'T'HH:mm:ss，如：2013-01-01T01:01:01。
	 */
    public static String getISODateTime() {
		return getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
	}
    
    /**
     * 获取完整的ISO日期时间<br>
     * 
     * @return yyyy-MM-dd'T'HH:mm:ss.SSS，如：2013-01-01T01:01:01.001。
     */
    public static String getFullISODateTime() {
    	return getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date());
	}
	
    /**
     * 用给定的日期模式格式化日期<br>
     * 
     * @param pattern 日期模式
     * @return 返回指定日期模式的日期。
     */
    public static String getspecifiedDate(String pattern) {
    	return getSimpleDateFormat(pattern).format(new Date());
    }
    
    /**
	 * 用给定的日期构造SimpleDateFormat对象<br>
	 * 
	 * @param date 日期
	 * @return 返回指定日期所对应的SimpleDateFormat对象。
	 */
	public static SimpleDateFormat getSimpleDateFormatByDate(String date) {
		String pattern = "";
		if (!StringUtil.formatNullString(date).trim().equals("")) {
			if (date.indexOf("/") != -1) {
				pattern = "yyyy/MM/dd";
			} else if (date.indexOf("-") != -1) {
				pattern = "yyyy-MM-dd";
			} else {
				pattern = "yyyyMMdd";
			}
		}
		return getSimpleDateFormat(pattern);
	}
    
}
