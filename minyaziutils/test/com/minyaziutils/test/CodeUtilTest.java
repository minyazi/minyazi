package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.CodeUtil;
import com.minyaziutils.LogUtil;

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
