package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.LogUtil;
import com.minyaziutils.StringUtil;

/**
 * 字符串工具类Test<br>
 * 
 * @author minyazi
 */
public class StringUtilTest {
	
	@Test
	public void testGetUUID() {
		LogUtil.info(StringUtil.getUUID());
	}
	
	@Test
	public void testFill() {
		LogUtil.info(StringUtil.fill("1", "3", 5));
	}
	
}
