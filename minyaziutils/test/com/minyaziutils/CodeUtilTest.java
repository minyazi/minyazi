package com.minyaziutils;

import org.junit.Test;

/**
 * 代码工具类Test<br>
 * 
 * @author minyazi
 */
public class CodeUtilTest {

	@Test
	public void testInit() {
		CodeUtil.init();
		LogUtil.info(CodeUtil.getCodes());
		LogUtil.info(CodeUtil.getCodeItemValue("filter", "html"));
	}

}
