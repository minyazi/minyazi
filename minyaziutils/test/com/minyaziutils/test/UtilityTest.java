package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.LogUtil;
import com.minyaziutils.Utility;

/**
 * 工具类Test<br>
 * 
 * @author minyazi
 */
public class UtilityTest {
	
	public UtilityTest() {
		
	}
	
	@Test
	public void testGetClassPath() {
		LogUtil.info(Utility.getClassPath());
	}
	
}
