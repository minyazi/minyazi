package com.minyaziutils;

import org.junit.Test;

/**
 * 日期工具类Test<br>
 * 
 * @author minyazi
 */
public class DateUtilTest {
	
	@Test
	public void testGetDate() {
		Utility.infoLog(DateUtil.getDate());
	}
	
	@Test
	public void testGetISODate() {
		Utility.infoLog(DateUtil.getISODate());
	}
	
}
