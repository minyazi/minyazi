package com.minyaziutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64工具类<br>
 * 
 * @author minyazi
 */
public class Base64Util {
	
	/**
	 * 使用Base64加密字符串<br>
	 * 
	 * @param value 要加密的字符串
	 * @return 返回加密后的结果。
	 */
	public static String encodeString(String value) {
		byte[] base64Bytes = Base64.encodeBase64(value.getBytes());
		return new String(base64Bytes);
	}
	
	/**
	 * 使用Base64解密字符串<br>
	 * 
	 * @param base64String 要解密的Base64字符串
	 * @return 返回解密后的结果。
	 */
	public static String decodeString(String base64String) {
		byte[] result = Base64.decodeBase64(base64String);
		return new String(result);
	}
	
	/**
	 * 使用Base64加密文件<br>
	 * 
	 * @param file 要加密的文件
	 * @return 返回加密后的结果。
	 */
	public static String encodeFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[(int) file.length()];
			fis.read(buffer);
			fis.close();
			byte[] base64Bytes = Base64.encodeBase64(buffer);
			return new String(base64Bytes);
		} catch (FileNotFoundException e) {
			PlatformException pe = new PlatformException("Base64加密文件出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		} catch (IOException e) {
			PlatformException pe = new PlatformException("Base64加密文件出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 使用Base64加密文件<br>
	 * 
	 * @param filePath 要加密的文件所在路径
	 * @param filename 要加密的文件的文件名
	 * @return 返回加密后的结果。
	 */
	public static String encodeFile(String filePath, String filename) {
		String path = filePath + "/" + filename;
		File file = new File(path);
		return encodeFile(file);
	}
	
	/**
	 * 使用Base64解密文件<br>
	 * 
	 * @param base64String 要解密的Base64字符串
	 * @param filePath 保存路径
	 * @param filename 保存文件名
	 * @return 返回解密后的结果。
	 */
	public static void decodeFile(String base64String, String filePath, String filename) {
		try {
			byte[] result = Base64.decodeBase64(base64String);
			FileOutputStream fos = new FileOutputStream(filePath + "/" + filename);
			fos.write(result);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			PlatformException pe = new PlatformException("Base64解密文件出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		} catch (IOException e) {
			PlatformException pe = new PlatformException("Base64解密文件出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
}
