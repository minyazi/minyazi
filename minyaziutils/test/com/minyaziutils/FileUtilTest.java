package com.minyaziutils;

import org.junit.Test;

/**
 * 文件工具类Test<br>
 * 
 * @author minyazi
 */
public class FileUtilTest {
	
	@Test
	public void testReadFile() {
		LogUtil.info(FileUtil.readFile(Utility.getClassPath(), "code-config.xml", "UTF-8", false));
	}
	
}
