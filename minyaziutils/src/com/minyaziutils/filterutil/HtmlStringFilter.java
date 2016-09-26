package com.minyaziutils.filterutil;

/**
 * HTML字符过滤器<br>
 * 
 * @author minyazi
 */
public class HtmlStringFilter extends AbstractStringFilter {
	
	@Override
	public String doFilter(String value) {
		if (value == null) {
			return null;
		}
		value = value.replaceAll("\\t", "    ")
					 .replaceAll("&", "&amp;")
					 .replaceAll(" ", "&nbsp;")
					 .replaceAll("<", "&lt;")
					 .replaceAll(">", "&gt;")
					 .replaceAll("\"", "&quot;");
		return value;
	}
	
}
