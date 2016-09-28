package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.JdbcUtil;
import com.minyaziutils.LogUtil;

/**
 * JDBC工具类Test<br>
 * 
 * @author minyazi
 */
public class JdbcUtilTest {
	
	@Test
	public void testInit() {
		JdbcUtil.init();
		LogUtil.info(JdbcUtil.queryToMap("select * from test"));
	}
	
}
