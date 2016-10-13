package com.minyaziutils.filterutil;

import java.util.Locale;

/**
 * 大写字符过滤器<br>
 * 
 * @author minyazi
 */
public class UpperStringFilter extends AbstractStringFilter {
	
	public UpperStringFilter() {
		
	}
	
	@Override
	public String doFilter(String value) {
		if (value == null) {
			return null;
		}
		return value.toUpperCase(Locale.ENGLISH);
	}
	
}
