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
		LogUtil.info(DateUtil.getDate());
	}
	
	@Test
	public void testGetISODate() {
		LogUtil.info(DateUtil.getISODate());
	}
	
}
