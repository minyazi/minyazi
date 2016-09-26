package com.minyaziutils.filterutil;

/**
 * 字符过滤器<br>
 * 
 * @author minyazi
 */
public interface StringFilter {
	
	/**
	 * 设置下一个字符过滤器<br>
	 * 
	 * @param filter 字符过滤器
	 */
	public abstract void setNextStringFilter(StringFilter filter);
	
	/**
	 * 字符过滤<br>
	 * 
	 * @param value 要过滤的字符
	 * @return 返回过滤后的字符。
	 */
	public abstract String filter(String value);
	
}
