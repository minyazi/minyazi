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
	
	/**
	 * 字符串补位（不足补位长度的按补位类型补位，超过补位长度的截掉超过部分）<br>
	 * 
	 * @param value 要补位的字符串
	 * @param fillType 补位类型（0：不补位，1：前补空格，2：后补空格，3：前补0，4：后补0）
	 * @param fillLength 补位长度
	 * @return 返回补位后的字符串。
	 */
	public static String fill(String value, String fillType, Integer fillLength) {
		value = formatNullString(value);
		int valueLength = value.length();
		if (formatNullString(fillType).trim().equals("")){
			fillType = "0";
		}
		if ("01234".indexOf(fillType) == -1) {
			PlatformException pe = new PlatformException("补位类型错误");
			LogUtil.exception(pe);
			throw pe;
		}
		if (fillLength == null) {
			fillLength = valueLength;
		}
		
		if (valueLength > fillLength) {
			value = value.substring(0, fillLength);
		} else if (valueLength < fillLength) {
			if (!fillType.equals("0")) {
				StringBuilder temp = new StringBuilder(value);
				int j = fillLength - valueLength;
				for (int i = 0; i < j; i++) {
					if (fillType.equals("1")) { // 前补空格
						temp.insert(0, " ");
					} else if (fillType.equals("2")) { // 后补空格
						temp.append(" ");
					} else if (fillType.equals("3")) { // 前补0
						temp.insert(0, "0");
					} else if (fillType.equals("4")) { // 后补0
						temp.append("0");
					}
				}
				value = temp.toString();
			}
		}
		
		return value;
	}
	
}