package com.minyaziutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类<br>
 * 
 * @author minyazi
 */
public class DateUtil {
	
	/**
	 * 获取日期<br>
	 * 
	 * @return yyyyMMdd，如:20160101
	 */
	public static String getDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取时间<br>
	 * 
	 * @return HHmmss，如：010101
	 */
	public static String getTime() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
	
	/**
	 * 获取日期时间<br>
	 * 
	 * @return yyyyMMddHHmmss，如：20160101010101
	 */
    public static String getDateTime()  {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
    
    /**
     * 获取完整的日期时间<br>
     * 
     * @return yyyyMMddHHmmssSSS，如：20130101010101001
     */
    public static String getFullDateTime() {
    	return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
    
    /**
	 * 获取日期<br>
	 * 
	 * @return yyyy-MM-dd，如:2013-01-01
	 */
	public static String getISODate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 获取时间<br>
	 * 
	 * @return HH:mm:ss，如：01:01:01
	 */
	public static String getISOTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	/**
	 * 获取日期时间<br>
	 * 
	 * @return yyyy-MM-dd'T'HH:mm:ss，如：2013-01-01T01:01:01
	 */
    public static String getISODateTime() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
	}
    
    /**
     * 获取完整的日期时间<br>
     * 
     * @return yyyy-MM-dd'T'HH:mm:ss.SSS，如：2013-01-01T01:01:01.001
     */
    public static String getFullISODateTime() {
    	return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date());
	}
	
}
