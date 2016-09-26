package com.minyaziutils.filterutil;

import org.junit.Test;

import com.minyaziutils.LogUtil;

public class StringFilterFactoryTest {
	
	@Test
	public void test() {
		String chain = "html,upper";
		StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilterChain(chain);
		LogUtil.info(stringFilter.filter("<title>test测试<title>"));
	}
	
}
