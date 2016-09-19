package com.minyaziutils;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 日期工具测试类<br>
 * 
 * @author minyazi
 */
public class DateUtilTest {
	
	private static final Logger logger = Utility.getLogger(DateUtilTest.class.getName());
	
	@Test
	public void testGetDate() {
		logger.info(DateUtil.getDate());
	}
	
	@Test
	public void testGetISODate() {
		logger.info(DateUtil.getISODate());
	}
	
}
