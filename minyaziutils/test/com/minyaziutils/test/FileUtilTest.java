package com.minyaziutils.test;

import org.junit.Test;

import com.minyaziutils.FileUtil;
import com.minyaziutils.LogUtil;
import com.minyaziutils.Utility;

/**
 * 文件工具类Test<br>
 * 
 * @author minyazi
 */
public class FileUtilTest {
	
	@Test
	public void testReadFile() {
		LogUtil.info(FileUtil.readFile(Utility.getClassPath(), "code-config.xml", "UTF-8", false, true));
	}
	
}
