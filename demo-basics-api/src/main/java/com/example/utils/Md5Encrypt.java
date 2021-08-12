package com.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 */
public class Md5Encrypt {
	/**
	 * MD5对字符串加密
	 * @param bytes
	 * @return
	 */
	public static String MD5(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(bytes);
			byte[] b = md.digest();
			for (int i = 0; i < b.length; i++) {
				int temp = b[i] & 0xff;
				if (temp < 16) {
                    strBuf.append("0");
                }
				strBuf.append(Integer.toHexString(temp));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}

	/**
	 * MD5对字符串加密
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return MD5(str.getBytes());
	}
}