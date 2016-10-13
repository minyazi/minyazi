package com.minyaziutils.filterutil;

/**
 * Empty字符过滤器<br>
 * 
 * @author minyazi
 */
public class EmptyStringFilter extends AbstractStringFilter {
	
	public EmptyStringFilter() {
		
	}
	
	@Override
	public String doFilter(String value) {
		return value;
	}
	
}
