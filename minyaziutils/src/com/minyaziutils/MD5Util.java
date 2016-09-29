package com.minyaziutils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类<br>
 * 
 * @author minyazi
 */
public class MD5Util {
	
	/**
	 * MD5加密<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回存放哈希值结果的byte数组。
	 */
	public static byte[] getMD5Bytes(String message) {
		try {
			// 获取MD5加密算法的信息摘要
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 添加要加密的信息
			md5.update(message.getBytes());
			return md5.digest();
		} catch (NoSuchAlgorithmException e) {
			PlatformException pe = new PlatformException("MD5加密出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 获取32位小写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回32位小写的MD5加密串。
	 */
	public static String get32LowerMD5(String message) {
		byte[] md5Bytes = getMD5Bytes(message);
		StringBuilder result = new StringBuilder(500);
		for (byte md5Byte : md5Bytes) {
			String value = Integer.toHexString(0xff & md5Byte);
			if (value.length() == 1) {
				result.append("0" + value);
			} else {
				result.append(value);
			}
		}
		return result.toString();
	}
	
	/**
	 * 获取32位大写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回32位大写的MD5加密串。
	 */
	public static String get32UpperMD5(String message) {
		byte[] md5Bytes = getMD5Bytes(message);
		char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] result = new char[md5Bytes.length * 2];
		int j = 0;
		for (int i = 0; i < md5Bytes.length; i++) {
			byte value = md5Bytes[i];
			result[j++] = hexChars[value >>> 4 & 0xf];
			result[j++] = hexChars[value & 0xf];
		}
		return new String(result);
	}
	
	/**
	 * 获取16位小写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回16位小写的MD5加密串。
	 */
	public static String get16LowerMD5(String message) {
		byte[] md5Bytes = getMD5Bytes(message);
		StringBuilder result = new StringBuilder(500);
		for (int i = 0; i < md5Bytes.length; i++) {
			int value = ((int) md5Bytes[i]) & 0xff;
			if (value < 16) {
				result.append("0");
			}
			result.append(Integer.toHexString(value));
		}
		return result.toString().substring(8, 24);
	}
	
	/**
	 * 获取16位大写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回16位大写的MD5加密串。
	 */
	public static String get16UpperMD5(String message) {
		byte[] md5Bytes = getMD5Bytes(message);
		StringBuilder result = new StringBuilder(500);
		for (int i = 0; i < md5Bytes.length; i++) {
			int value = (int) md5Bytes[i];
			if (value < 0) {
				value += 256;
			}
			if (value < 16) {
				result.append("0");
			}
			result.append(Integer.toHexString(value));
		}
		return StringUtil.toUpperCase(result.toString().substring(8, 24));
	}
	
	/**
	 * MD5加密<br>
	 * 
	 * @param message 要加密的信息
	 * @return 返回存放哈希值结果的byte数组。
	 */
	public static byte[] getMD5Bytes(String message, String encoding) {
		try {
			// 获取MD5加密算法的信息摘要
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 添加要加密的信息
			md5.update(message.getBytes(encoding));
			return md5.digest();
		} catch (NoSuchAlgorithmException e) {
			PlatformException pe = new PlatformException("MD5加密出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		} catch (UnsupportedEncodingException e) {
			PlatformException pe = new PlatformException("MD5加密出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 获取32位小写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @param encoding 字符编码
	 * @return 返回32位小写的MD5加密串。
	 */
	public static String get32LowerMD5(String message, String encoding) {
		byte[] md5Bytes = getMD5Bytes(message, encoding);
		StringBuilder result = new StringBuilder(500);
		for (byte md5Byte : md5Bytes) {
			String value = Integer.toHexString(0xff & md5Byte);
			if (value.length() == 1) {
				result.append("0" + value);
			} else {
				result.append(value);
			}
		}
		return result.toString();
	}
	
	/**
	 * 获取32位大写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @param encoding 字符编码
	 * @return 返回32位大写的MD5加密串。
	 */
	public static String get32UpperMD5(String message, String encoding) {
		return StringUtil.toUpperCase(get32LowerMD5(message, encoding));
	}
	
	/**
	 * 获取16位小写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @param encoding 字符编码
	 * @return 返回16位小写的MD5加密串。
	 */
	public static String get16LowerMD5(String message, String encoding) {
		return get32LowerMD5(message, encoding).substring(8, 24);
	}
	
	/**
	 * 获取16位大写的MD5加密串<br>
	 * 
	 * @param message 要加密的信息
	 * @param encoding 字符编码
	 * @return 返回16位大写的MD5加密串。
	 */
	public static String get16UpperMD5(String message, String encoding) {
		return get32UpperMD5(message, encoding).substring(8, 24);
	}
	
	/**
	 * 加密/解密算法（执行一次加密，执行两次解密）<br>
	 * 
	 * @param message 要加密/解密的信息
	 * @return 返回加密/解密后的信息。
	 */
	public static String convert(String message) {
		char[] value = message.toCharArray();
		for (int i = 0; i < value.length; i++) {
			value[i] = (char) (value[i] ^ 't');
		}
		return new String(value);
	}
	
}
