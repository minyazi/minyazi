package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.LogUtil;
import com.minyaziutils.filterutil.StringFilter;
import com.minyaziutils.filterutil.StringFilterFactory;

public class StringFilterFactoryTest {
	
	@Test
	public void test() {
		String chain = "html,upper";
		StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilterChain(chain);
		LogUtil.info(stringFilter.filter("<title>test测试<title>"));
	}
	
}
