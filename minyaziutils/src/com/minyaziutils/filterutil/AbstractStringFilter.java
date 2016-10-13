package com.minyaziutils.filterutil;

/**
 * Abstract字符过滤器<br>
 * 
 * @author minyazi
 */
public abstract class AbstractStringFilter implements StringFilter {
	
	private StringFilter filter;
	
	public AbstractStringFilter() {
		
	}
	
	@Override
	public void setNextStringFilter(StringFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public String filter(String value) {
		value = doFilter(value);
		if (filter == null) {
			return value;
		}
		// 使用下一个字符过滤器继续过滤
		return filter.filter(value);
	}
	
	/**
	 * 字符过滤模板方法<br>
	 * 
	 * @param value 要过滤的字符
	 * @return 返回过滤后的字符。
	 */
	public abstract String doFilter(String value);

}
